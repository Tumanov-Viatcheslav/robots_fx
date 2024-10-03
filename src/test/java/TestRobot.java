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
}
