package org.robots.robots_fx.robot;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import org.robots.robots_fx.RobotsController;

public class RobotView extends Rectangle {
    Polygon shape;
    public Property<Direction> directionProperty = new SimpleObjectProperty<>(Direction.NORTH);
    public RobotView() {
        setVisible(false);
        setFill(Color.color(Math.random(), Math.random(), Math.random()));
    }

    public void changeTriangle(ObservableList<Node> children) {
        if (shape != null)
            children.remove(shape);
        createTriangle();
        children.add(shape);
    }

    private void createTriangle() {
        int step = RobotsController.STEP;
        switch (directionProperty.getValue()) {
            case NORTH:
                shape = new Polygon(
                        getX(), getY() + 2 * step,
                        getX() + step, getY(),
                        getX() + 2 * step, getY() + 2 * step
                );
                break;
            case WEST:
                shape = new Polygon(
                        getX() + 2 * step, getY(),
                        getX(), getY() + step,
                        getX() + 2 * step, getY() + 2 * step
                );
                break;
            case SOUTH:
                shape = new Polygon(
                        getX(), getY(),
                        getX() + step, getY() + 2 * step,
                        getX() + 2 * step, getY()
                );
                break;
            case EAST:
                shape = new Polygon(
                        getX(), getY(),
                        getX() + 2 * step, getY() + step,
                        getX(), getY() + 2 * step
                );
                break;
        }
        shape.setFill(getFill());
    }
}
