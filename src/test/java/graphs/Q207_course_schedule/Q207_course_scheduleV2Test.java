package graphs.Q207_course_schedule;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Q207_course_scheduleV2Test {

    @Test
    void noCycle() {
        Q207_course_scheduleV1 solution = new Q207_course_scheduleV1();
        int numCoursesInput = 3;
        int[][] prereqInput = new int[][]{
                {1, 0}, {0, 2}, {1, 2}
        };
        boolean result = solution.canFinish(numCoursesInput, prereqInput);
        assertTrue(result);
    }

    @Test
    void cycle() {
        Q207_course_scheduleV1 solution = new Q207_course_scheduleV1();
        int numCoursesInput = 3;
        int[][] prereqInput = new int[][]{
                {1, 0}, {0, 2}, {2, 1}
        };
        boolean result = solution.canFinish(numCoursesInput, prereqInput);
        assertFalse(result);
    }

    @Test
    void cycleWithLeafGoingInAndLeafGoingOut() {
        Q207_course_scheduleV1 solution = new Q207_course_scheduleV1();
        int numCoursesInput = 5;
        int[][] prereqInput = new int[][]{
                {1, 0}, {0, 2}, {2, 1}, {1, 4}, {3, 2}
        };
        boolean result = solution.canFinish(numCoursesInput, prereqInput);
        assertFalse(result);
    }

    @Test
    void twoCourses() {
        Q207_course_scheduleV1 solution = new Q207_course_scheduleV1();
        int numCoursesInput = 2;
        int[][] prereqInput = new int[][]{
                {1, 0}
        };
        boolean result = solution.canFinish(numCoursesInput, prereqInput);
        assertTrue(result);
    }
}