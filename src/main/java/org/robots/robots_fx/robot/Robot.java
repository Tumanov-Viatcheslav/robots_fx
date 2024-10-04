package org.robots.robots_fx.robot;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.io.*;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Robot {
    private final IntegerProperty x = new SimpleIntegerProperty();
    private final IntegerProperty y = new SimpleIntegerProperty();
    private final Property<Direction> directionProperty = new SimpleObjectProperty<>(Direction.NORTH);
    private final Queue<Action> commandsToDo = new LinkedList<>();

    public Robot() {
    }

    public Robot(int x) {
        setX(x);
    }

    public Robot(int x, int y) {
        setX(x);
        setY(y);
    }

    public Robot(int x, int y, Direction direction) {
        setX(x);
        setY(y);
        setDirection(direction);
    }

    public Robot(int x, int y, Direction direction, String commands) {
        setX(x);
        setY(y);
        setDirection(direction);
        this.inputProgram(commands);
    }

    public Integer getX() {
        return x.getValue();
    }

    public IntegerProperty xProperty() {
        return x;
    }

    public void setX(Integer x) {
        this.x.setValue(x);
    }

    public Integer getY() {
        return y.getValue();
    }

    public IntegerProperty yProperty() {
        return y;
    }

    public void setY(Integer y) {
        this.y.setValue(y);
    }

    public Direction getDirection() {
        return directionProperty.getValue();
    }

    public Property<Direction> getDirectionProperty() {
        return directionProperty;
    }

    public void setDirection(Direction direction) {
        directionProperty.setValue(direction);
    }

    private void turnLeft() {
        switch (getDirection()) {
            case NORTH:
                setDirection(Direction.WEST);
                return;
            case WEST:
                setDirection(Direction.SOUTH);
                return;
            case SOUTH:
                setDirection(Direction.EAST);
                return;
            case EAST:
                setDirection(Direction.NORTH);
        }
    }

    private void turnRight() {
        switch (getDirection()) {
            case NORTH:
                setDirection(Direction.EAST);
                return;
            case EAST:
                setDirection(Direction.SOUTH);
                return;
            case SOUTH:
                setDirection(Direction.WEST);
                return;
            case WEST:
                setDirection(Direction.NORTH);
        }
    }

    private void stepForward() {
        switch (getDirection()) {
            case NORTH:
                setY(getY() + 1);
                return;
            case WEST:
                setX(getX() - 1);
                return;
            case SOUTH:
                setY(getY() - 1);
                return;
            case EAST:
                setX(getX() + 1);
        }
    }

    private void executeAction(Action action) {
        switch (action) {
            case FORWARD:
                stepForward();
                break;
            case LEFT:
                turnLeft();
                break;
            case RIGHT:
                turnRight();
                break;
        }
    }

    public boolean doAction() {
        if (!commandsToDo.isEmpty()) {
            executeAction(commandsToDo.poll());
            return true;
        }
        return false;
    }

    public void inputProgram(String commands) {
        for (char c : commands.toCharArray()) {
            switch (c) {
                case 'S':
                    commandsToDo.add(Action.FORWARD);
                    break;
                case 'L':
                    commandsToDo.add(Action.LEFT);
                    break;
                case 'R':
                    commandsToDo.add(Action.RIGHT);
                    break;
            }
        }
    }

    public static Robot[] readRobots(String fileName) {
        List<Robot> robots = new ArrayList<>();
        try(BufferedReader input = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = input.readLine()) != null) {
                String[] robotStr = line.split(";");
                try {
                    switch (robotStr.length) {
                        case 0:
                            robots.add(new Robot());
                            break;
                        case 1:
                            Integer.parseInt(robotStr[0]);
                            robots.add(new Robot(Integer.parseInt(robotStr[0])));
                            break;
                        case 2:
                            Integer.parseInt(robotStr[0]);
                            Integer.parseInt(robotStr[1]);
                            robots.add(new Robot(Integer.parseInt(robotStr[0]), Integer.parseInt(robotStr[1])));
                            break;
                        case 3:
                            Integer.parseInt(robotStr[0]);
                            Integer.parseInt(robotStr[1]);
                            Direction.valueOf(robotStr[2]);
                            robots.add(new Robot(Integer.parseInt(robotStr[0]), Integer.parseInt(robotStr[1]), Direction.valueOf(robotStr[2])));
                            break;
                        case 4:
                            Integer.parseInt(robotStr[0]);
                            Integer.parseInt(robotStr[1]);
                            Direction.valueOf(robotStr[2]);
                            robots.add(new Robot(Integer.parseInt(robotStr[0]), Integer.parseInt(robotStr[1]), Direction.valueOf(robotStr[2]), robotStr[3]));
                            break;
                        default:
                            throw new InvalidParameterException("Wrong number of robot parameters");
                    }
                }
                catch (Exception ex) {
                    System.out.println(ex.getClass().getName() + ": " + ex.getMessage());
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getClass().getName() + ": " + ex.getMessage());
        }
        return robots.toArray(new Robot[0]);
    }
}