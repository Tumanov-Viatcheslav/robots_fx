import org.junit.jupiter.api.*;
import org.robots.robots_fx.robot.Direction;
import org.robots.robots_fx.robot.Robot;

public class TestRobot {
    @BeforeEach
    void testStarted(TestInfo test) {
        System.out.println(test.getDisplayName() + " started");
    }

    @AfterEach
    void testFinished(TestInfo test) {
        System.out.println(test.getDisplayName() + " finished\n--------------------------------------------");
    }

    @Nested
    public class TestConstructor {
        @Test
        @DisplayName("Empty Constructor Test")
        void testRobotEmptyConstructor() {
            Assertions.assertDoesNotThrow(() -> new Robot());
        }

        @Test
        @DisplayName("Constructor Test #1")
        void testRobotConstructor1() {
            Assertions.assertDoesNotThrow(() -> new Robot(1));
        }

        @Test
        @DisplayName("Constructor Test #2")
        void testRobotConstructor2() {
            Assertions.assertDoesNotThrow(() -> new Robot(1, 1));
        }

        @Test
        @DisplayName("Constructor Test #3")
        void testRobotConstructor3() {
            Assertions.assertDoesNotThrow(() -> new Robot(1, 1, Direction.SOUTH));
        }

        @Test
        @DisplayName("Constructor Test #4")
        void testRobotConstructor4() {
            Assertions.assertDoesNotThrow(() -> new Robot(1, 1, Direction.SOUTH, "SRRSLSSS"));
            Assertions.assertDoesNotThrow(() -> new Robot(1, 1, Direction.SOUTH, ""));
        }

        @Test
        @DisplayName("Constructor Test #5")
        void testRobotConstructor5() {
            Assertions.assertDoesNotThrow(() -> new Robot(1, 1, Direction.SOUTH, "gfhSRfghR SgfhLSfgh\nSfghfdS"));
        }
    }

    @Nested
    public class TestXCoordinate {
        @Test
        @DisplayName("X Coordinate Test #1")
        void testRobotX1() {
            Robot robot = new Robot(1, 1, Direction.SOUTH, "SRRSLSSS");
            Assertions.assertDoesNotThrow(robot::getX);
            Assertions.assertEquals(1, robot.getX());
        }

        @Test
        @DisplayName("X Coordinate Test #2")
        void testRobotX2() {
            Robot robot = new Robot(1, 1, Direction.SOUTH, "SRRSLSSS");
            Assertions.assertDoesNotThrow(() -> robot.setX(-1));
            Assertions.assertEquals(-1, robot.getX());
        }

        @Test
        @DisplayName("X Coordinate Test #3")
        void testRobotX3() {
            Robot robot = new Robot(1, 1, Direction.SOUTH, "SRRSLSSS");
            Assertions.assertEquals(1, robot.getX());
            Assertions.assertEquals(1, robot.getX());
        }

        @Test
        @DisplayName("X Coordinate Test #4")
        void testRobotX4() {
            Robot robot = new Robot(1, 1, Direction.SOUTH, "SRRSLSSS");
            Assertions.assertDoesNotThrow(robot::xProperty);
        }

        @Test
        @DisplayName("X Coordinate Test #5")
        void testRobotX5() {
            Robot robot = new Robot(1, 1, Direction.SOUTH, "SRRSLSSS");
            Assertions.assertEquals(1, robot.xProperty().getValue());
            Assertions.assertEquals(1, robot.xProperty().getValue());
        }
    }

    @Nested
    public class TestYCoordinate {
        @Test
        @DisplayName("Y Coordinate Test #1")
        void testRobotY1() {
            Robot robot = new Robot(1, 1, Direction.SOUTH, "SRRSLSSS");
            Assertions.assertDoesNotThrow(robot::getY);
            Assertions.assertEquals(1, robot.getY());
        }

        @Test
        @DisplayName("Y Coordinate Test #2")
        void testRobotY2() {
            Robot robot = new Robot(1, 1, Direction.SOUTH, "SRRSLSSS");
            Assertions.assertDoesNotThrow(() -> robot.setY(-1));
            Assertions.assertEquals(-1, robot.getY());
        }

        @Test
        @DisplayName("Y Coordinate Test #3")
        void testRobotY3() {
            Robot robot = new Robot(1, 1, Direction.SOUTH, "SRRSLSSS");
            Assertions.assertEquals(1, robot.getY());
            Assertions.assertEquals(1, robot.getY());
        }

        @Test
        @DisplayName("Y Coordinate Test #4")
        void testRobotY4() {
            Robot robot = new Robot(1, 1, Direction.SOUTH, "SRRSLSSS");
            Assertions.assertDoesNotThrow(robot::yProperty);
        }

        @Test
        @DisplayName("Y Coordinate Test #5")
        void testRobotY5() {
            Robot robot = new Robot(1, 1, Direction.SOUTH, "SRRSLSSS");
            Assertions.assertEquals(1, robot.yProperty().getValue());
            Assertions.assertEquals(1, robot.yProperty().getValue());
        }
    }

    @Nested
    public class TestDirection {
        @Test
        @DisplayName("Direction Test #1")
        void testRobotDirection1() {
            Robot robot = new Robot(1, 1, Direction.SOUTH, "SRRSLSSS");
            Assertions.assertDoesNotThrow(robot::getDirection);
            Assertions.assertEquals(Direction.SOUTH, robot.getDirection());
        }

        @Test
        @DisplayName("Direction Test #2")
        void testRobotDirection2() {
            Robot robot = new Robot(1, 1, Direction.SOUTH, "SRRSLSSS");
            Assertions.assertDoesNotThrow(() -> robot.setDirection(Direction.EAST));
            Assertions.assertEquals(Direction.EAST, robot.getDirection());
        }

        @Test
        @DisplayName("Direction Test #3")
        void testRobotDirection3() {
            Robot robot = new Robot(1, 1, Direction.SOUTH, "SRRSLSSS");
            Assertions.assertEquals(Direction.SOUTH, robot.getDirection());
            Assertions.assertEquals(Direction.SOUTH, robot.getDirection());
        }

        @Test
        @DisplayName("Direction Test #4")
        void testRobotDirection4() {
            Robot robot = new Robot(1, 1, Direction.SOUTH, "SRRSLSSS");
            Assertions.assertDoesNotThrow(robot::getDirectionProperty);
        }

        @Test
        @DisplayName("Direction Test #5")
        void testRobotDirection5() {
            Robot robot = new Robot(1, 1, Direction.SOUTH, "SRRSLSSS");
            Assertions.assertEquals(Direction.SOUTH, robot.getDirectionProperty().getValue());
            Assertions.assertEquals(Direction.SOUTH, robot.getDirectionProperty().getValue());
        }
    }

    @Nested
    public class TestAction {
        @Test
        @DisplayName("Action Test #1")
        void testRobotAction1() {
            Robot robot = new Robot(1, 1, Direction.SOUTH, "SRRSLSSS");
            Assertions.assertDoesNotThrow(robot::doAction);
        }

        @Test
        @DisplayName("Action Test #2")
        void testRobotAction2() {
            Robot robot = new Robot(10, 1, Direction.SOUTH, "SRRSLSSS");
            Assertions.assertTrue(robot.doAction());
            Assertions.assertEquals(0, robot.getY());
            Assertions.assertEquals(10, robot.getX());
            Assertions.assertEquals(Direction.SOUTH, robot.getDirection());
        }

        @Test
        @DisplayName("Action Test #3")
        void testRobotAction3() {
            Robot robot = new Robot(1, 2, Direction.SOUTH, "RRRSLSSS");
            Assertions.assertTrue(robot.doAction());
            Assertions.assertEquals(Direction.WEST, robot.getDirection());
            Assertions.assertEquals(1, robot.getX());
            Assertions.assertEquals(2, robot.getY());
        }

        @Test
        @DisplayName("Action Test #4")
        void testRobotAction4() {
            Robot robot = new Robot(1, 2, Direction.SOUTH, "LRRSLSSS");
            Assertions.assertTrue(robot.doAction());
            Assertions.assertEquals(Direction.EAST, robot.getDirection());
            Assertions.assertEquals(1, robot.getX());
            Assertions.assertEquals(2, robot.getY());
        }

        @Test
        @DisplayName("Action Test #5")
        void testRobotAction5() {
            Robot robot = new Robot(1, 2, Direction.SOUTH, "");
            Assertions.assertFalse(robot.doAction());
            Assertions.assertEquals(1, robot.getX());
            Assertions.assertEquals(2, robot.getY());
            Assertions.assertEquals(Direction.SOUTH, robot.getDirection());
        }
    }

    @Nested
    public class TestInputProgram {
        @Test
        @DisplayName("Input Program #1")
        void testRobotInputProgram1() {
            Robot robot = new Robot(1, 1, Direction.SOUTH);
            Assertions.assertDoesNotThrow(() -> robot.inputProgram("SRSSL"));
        }

        @Test
        @DisplayName("Input Program #2")
        void testRobotInputProgram2() {
            Robot robot = new Robot(1, 1, Direction.SOUTH);
            Assertions.assertDoesNotThrow(() -> robot.inputProgram(""));
            Assertions.assertFalse(robot.doAction());
        }

        @Test
        @DisplayName("Input Program #3")
        void testRobotInputProgram3() {
            Robot robot = new Robot(1, 1, Direction.SOUTH);
            robot.inputProgram("SRSSL");
            int counter = 0;
            while (robot.doAction()) {
                counter++;
            }
            Assertions.assertEquals(5, counter);
            Assertions.assertEquals(-1, robot.getX());
            Assertions.assertEquals(0, robot.getY());
            Assertions.assertEquals(Direction.SOUTH, robot.getDirection());
        }

        @Test
        @DisplayName("Input Program #4")
        void testRobotInputProgram4() {
            Robot robot = new Robot(1, 1, Direction.SOUTH);
            robot.inputProgram("SgfhfdhR\nfdhgdfg\n _  \r\nSSsssrrrL/////");
            int counter = 0;
            while (robot.doAction()) {
                counter++;
            }
            Assertions.assertEquals(5, counter);
            Assertions.assertEquals(-1, robot.getX());
            Assertions.assertEquals(0, robot.getY());
            Assertions.assertEquals(Direction.SOUTH, robot.getDirection());
        }

        @Test
        @DisplayName("Input Program #5")
        void testRobotInputProgram5() {
            Robot robot = new Robot(10, 1, Direction.SOUTH);
            robot.inputProgram("S");
            Assertions.assertTrue(robot.doAction());
            Assertions.assertEquals(0, robot.getY());
            Assertions.assertEquals(10, robot.getX());
            Assertions.assertEquals(Direction.SOUTH, robot.getDirection());
        }

        @Test
        @DisplayName("Input Program #6")
        void testRobotInputProgram6() {
            Robot robot = new Robot(10, 1, Direction.SOUTH);
            robot.inputProgram("R");
            Assertions.assertTrue(robot.doAction());
            Assertions.assertEquals(1, robot.getY());
            Assertions.assertEquals(10, robot.getX());
            Assertions.assertEquals(Direction.WEST, robot.getDirection());
        }

        @Test
        @DisplayName("Input Program #7")
        void testRobotInputProgram7() {
            Robot robot = new Robot(10, 1, Direction.SOUTH);
            robot.inputProgram("L");
            Assertions.assertTrue(robot.doAction());
            Assertions.assertEquals(1, robot.getY());
            Assertions.assertEquals(10, robot.getX());
            Assertions.assertEquals(Direction.EAST, robot.getDirection());
        }
    }

    @Nested
    public class TestReadRobots {
        @Test
        @DisplayName("Read Robots #1")
        void testRobotReadRobots1() {
            Assertions.assertDoesNotThrow(() -> Robot.readRobots("input.txt"));
        }
        @Test
        @DisplayName("Read Robots #2")
        void testRobotReadRobots2() {
            Robot[] robots = Assertions.assertDoesNotThrow(() -> Robot.readRobots("src/test/resources/input.txt"));
            Assertions.assertEquals(6, robots.length);
        }
        @Test
        @DisplayName("Read Robots #3")
        void testRobotReadRobots3() {
            Robot[] robots = Assertions.assertDoesNotThrow(() -> Robot.readRobots("src/test/resources/inputWrong1.txt"));
            Assertions.assertEquals(0, robots.length);
        }
        @Test
        @DisplayName("Read Robots #4")
        void testRobotReadRobots4() {
            Robot[] robots = Assertions.assertDoesNotThrow(() -> Robot.readRobots("src/test/resources/inputWrong2.txt"));
            Assertions.assertEquals(0, robots.length);
        }
        @Test
        @DisplayName("Read Robots #5")
        void testRobotReadRobots5() {
            Robot[] robots = Assertions.assertDoesNotThrow(() -> Robot.readRobots("src/test/resources/inputWrong3.txt"));
            Assertions.assertEquals(1, robots.length);
        }
        @Test
        @DisplayName("Read Robots #6")
        void testRobotReadRobots6() {
            Robot[] robots = Assertions.assertDoesNotThrow(() -> Robot.readRobots("src/test/resources/inputWrong4.txt"));
            Assertions.assertEquals(1, robots.length);
        }
        @Test
        @DisplayName("Read Robots #7")
        void testRobotReadRobots7() {
            Robot[] robots = Assertions.assertDoesNotThrow(() -> Robot.readRobots("src/test/resources/inputEmpty.txt"));
            Assertions.assertEquals(0, robots.length);
        }
        @Test
        @DisplayName("Read Robots #8")
        void testRobotReadRobots8() {
            Robot[] robots = Assertions.assertDoesNotThrow(() -> Robot.readRobots("src/test/resources/input.txt"));
            Robot[] robotsExpected = {
                    new Robot(0, 0, Direction.NORTH, "SRRSLSSSRSSLLSLSLSSRSSLSLLLSSSRRSLSSSRSSLLSLSLSSRSSLSLLLSSLLSLSLSSRSSLSLLLS"),
                    new Robot(2, 2, Direction.SOUTH, "SSRRSLSSSRSSLLSLSLSLLLSSSLLSLSLSSSSRRSLSSSRSSLLSLSLSSRSSLSLLLS"),
                    new Robot(4, 4, Direction.EAST, "LSLSLSSSRRSLSSSRRSLSSSSLLSLSLSSRSSLSLLLSSSRRSLSSSRSSLSSLSLLLS"),
                    new Robot(6, 6, Direction.EAST, "SSRRSLSSSRSSLSSLSLLLSSLSSSRSSLLSLSLSLLLSSSLLSLSLSSSSRRSLSSSRSSLLSLSLSSR"),
                    new Robot(8, 8, Direction.WEST, "SSSSSRRSLSSSRSSLLSLSLSSRSSLSLLLSSLLSLSLSSRSSLSLLLS"),
                    new Robot(10, 10, Direction.NORTH)
            };
            Assertions.assertEquals(robotsExpected.length, robots.length);
        }
    }
}
