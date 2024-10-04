package org.robots.robots_fx;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import org.robots.robots_fx.robot.Robot;
import org.robots.robots_fx.robot.RobotView;

public class RobotsController {
    public static final int X_TRANSITION = 500,
            Y_TRANSITION = 300,
            STEP = 20;

    boolean isAnimated = false;

    Robot[] robots;

    private final AnimationTimer robotAnimation = new AnimationTimer() {
        private long prev = 0;
        @Override
        public void handle(long l) {
            if (prev == 0) {
                prev = l;
                for (Robot robot : robots)
                    robot.doAction();
                return;
            }
            if ((l - prev) / (1_000_000_000 / (int) FPSSlider.getValue()) > 0) {
                for (Robot robot : robots)
                    robot.doAction();
                prev = l;
            }
        }
    };

    @FXML
    public AnchorPane pane;
    @FXML
    public Label instructionText;
    @FXML
    public Label labelFPS;
    @FXML
    public Button button;
    @FXML
    public Slider FPSSlider;

    @FXML
    protected void onButtonClick() {
        if (isAnimated) {
            instructionText.setText("Click Start button to launch robots");
            button.setText("Start");
            robotAnimation.stop();
            isAnimated = false;
        }
        else {
            instructionText.setText("Enjoy!");
            button.setText("Stop");
            robotAnimation.start();
            isAnimated = true;
        }
    }

    @FXML
    protected void initialize() {
        robots = Robot.readRobots("src/main/resources/org/robots/robots_fx/input.txt");
        RobotView[] robotViews = new RobotView[robots.length];
        for (int i = 0; i < robots.length; i++) {
            robotViews[i] = new RobotView();
            pane.getChildren().add(robotViews[i]);
            int finalI = i;
            robotViews[i].xProperty().addListener((_, _, _) -> robotViews[finalI].changeTriangle(pane.getChildren()));
            robotViews[i].yProperty().addListener((_, _, _) -> robotViews[finalI].changeTriangle(pane.getChildren()));
            robotViews[i].directionProperty.addListener((_, _, _) -> robotViews[finalI].changeTriangle(pane.getChildren()));
            robotViews[i].xProperty().bind(robots[i].xProperty().multiply(STEP).add(X_TRANSITION));
            robotViews[i].yProperty().bind(robots[i].yProperty().multiply(-1).multiply(STEP).add(Y_TRANSITION));
            robotViews[i].directionProperty.bind(robots[i].getDirectionProperty());
            labelFPS.textProperty().bind(FPSSlider.valueProperty().asString().concat(" FPS"));
        }
        FPSSlider.setValue(3);
        FPSSlider.valueProperty().addListener((_, _, newVal) ->
                FPSSlider.setValue(newVal.intValue()));
    }
}