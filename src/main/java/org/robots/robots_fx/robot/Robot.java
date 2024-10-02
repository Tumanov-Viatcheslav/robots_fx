package org.robots.robots_fx.robot;


import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.shape.Rectangle;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Robot extends Rectangle {
    private Direction direction = Direction.NORTH;
    public Property<Direction> directionProperty = new SimpleObjectProperty<>(Direction.NORTH);
    private final Queue<Action> commandsToDo = new LinkedList<>();

    public Robot() {
        super(0, 0);
    }

    public Robot(int x, int y, Direction direction, String commands) {
        super(x, y, 10, 10);
        setVisible(false);
        this.direction = direction;
        directionProperty.setValue(direction);
        this.inputProgram(commands);
    }

    public Direction getDirection() {
        return direction;
    }

    private void turnLeft() {
        switch (direction) {
            case NORTH:
                direction = Direction.WEST;
                directionProperty.setValue(direction);
                return;
            case WEST:
                direction = Direction.SOUTH;
                directionProperty.setValue(direction);
                return;
            case SOUTH:
                direction = Direction.EAST;
                directionProperty.setValue(direction);
                return;
            case EAST:
                direction = Direction.NORTH;
                directionProperty.setValue(direction);
        }
    }

    private void turnRight() {
        switch (direction) {
            case NORTH:
                direction = Direction.EAST;
                directionProperty.setValue(direction);
                return;
            case EAST:
                direction = Direction.SOUTH;
                directionProperty.setValue(direction);
                return;
            case SOUTH:
                direction = Direction.WEST;
                directionProperty.setValue(direction);
                return;
            case WEST:
                direction = Direction.NORTH;
                directionProperty.setValue(direction);
        }
    }

    private void stepForward() {
        switch (direction) {
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

    public static Robot[] readRobots() {
        List<Robot> robots = new ArrayList<>();
        try(BufferedReader input = new BufferedReader(new FileReader("src/main/resources/org/robots/robots_fx/input.txt"))) {
            String line;
            while ((line = input.readLine()) != null) {
                String[] robotStr = line.split(";");
                robots.add(new Robot(Integer.parseInt(robotStr[0]), Integer.parseInt(robotStr[1]), Direction.valueOf(robotStr[2]), robotStr[3]));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return robots.toArray(new Robot[0]);
    }
}