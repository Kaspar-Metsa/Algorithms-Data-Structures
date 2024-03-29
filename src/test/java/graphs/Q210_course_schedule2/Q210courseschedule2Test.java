package graphs.Q210_course_schedule2;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Q210courseschedule2Test {

    @Test
    void cycle() {
        Q210_course_schedule2 solution = new Q210_course_schedule2();
        int numCourses = 3;
        int[][] prerequisites = new int[][]{
                {1, 0}, {0, 2}, {2, 1}
        };
        int[] result = solution.findOrder(numCourses, prerequisites);
        assertArrayEquals(result, new int[0]);
    }

    @Test
    void cycle2() {
        Q210_course_schedule2 solution = new Q210_course_schedule2();
        int numCourses = 5;
        int[][] prerequisites = new int[][]{
                {1, 0}, {0, 2}, {2, 1}, {1, 4}, {3, 2}
        };
        int[] result = solution.findOrder(numCourses, prerequisites);
        assertArrayEquals(result, new int[0]);
    }

    @Test
    void noCycle() {
        Q210_course_schedule2 solution = new Q210_course_schedule2();
        int numCourses = 3;
        int[][] prerequisites = new int[][]{
                {1, 0}, {0, 2}, {1, 2}
        };
        int[] result = solution.findOrder(numCourses, prerequisites);
        assertArrayEquals(result, new int[]{2, 0, 1});
    }

    @Test
    void noCycle2() {
        Q210_course_schedule2 solution = new Q210_course_schedule2();
        int numCourses = 4;
        int[][] prerequisites = new int[][]{
                {2, 1}, {2, 0}, {3, 2}
        };
        int[] result = solution.findOrder(numCourses, prerequisites);
        assertThat(result, Matchers.anyOf(is(new int[]{0, 1, 2, 3}), is(new int[]{1, 0, 2, 3})));
    }

    @Test
    void noCycle3() {
        Q210_course_schedule2 solution = new Q210_course_schedule2();
        int numCourses = 5;
        int[][] prerequisites = new int[][]{
                {0, 1}, {3, 0}, {3, 2}, {4, 3}
        };
        int[] result = solution.findOrder(numCourses, prerequisites);
        assertThat(result, Matchers.anyOf(is(new int[]{1, 0, 2, 3, 4}), is(new int[]{1, 2, 0, 3, 4}), is(new int[]{2, 1, 0, 3, 4})));
    }

    @Test
    void noCycle4() {
        Q210_course_schedule2 solution = new Q210_course_schedule2();
        int numCourses = 1;
        int[][] prerequisites = new int[][]{

        };
        int[] result = solution.findOrder(numCourses, prerequisites);
        assertArrayEquals(result, new int[]{0});
    }

    @Test
    void noCycle5() {
        Q210_course_schedule2 solution = new Q210_course_schedule2();
        int numCourses = 2;
        int[][] prerequisites = new int[][]{};
        int[] result = solution.findOrder(numCourses, prerequisites);
        assertThat(result, Matchers.anyOf(is(new int[]{1, 0}), is(new int[]{0, 1})));
    }
}