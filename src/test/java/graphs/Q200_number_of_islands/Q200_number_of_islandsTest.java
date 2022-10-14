package graphs.Q200_number_of_islands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q200_number_of_islandsTest {

    @Test
    void test1Island() {
        Q200_number_of_islands solution = new Q200_number_of_islands();
        char[][] input = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int result = solution.numIslands(input);
        assertEquals(1, result);
    }

    @Test
    void test2Islands() {
        Q200_number_of_islands solution = new Q200_number_of_islands();
        char[][] input = new char[][]{
                {'1', '0', '1', '1', '0'},
                {'1', '0', '0', '1', '0'},
                {'1', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int result = solution.numIslands(input);
        assertEquals(2, result);
    }


    @Test
    void test3Islands() {
        Q200_number_of_islands solution = new Q200_number_of_islands();
        char[][] input = new char[][]{
                {'1', '0', '1', '1', '0'},
                {'1', '0', '0', '1', '0'},
                {'1', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '1'}
        };
        int result = solution.numIslands(input);
        assertEquals(3, result);
    }

    @Test
    void test4Islands() {
        Q200_number_of_islands solution = new Q200_number_of_islands();
        char[][] input = new char[][]{
                {'1', '0', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
                {'1', '0', '1', '0', '0'},
                {'0', '1', '1', '0', '1'}
        };
        int result = solution.numIslands(input);
        assertEquals(4, result);
    }

    @Test
    void test0Islands() {
        Q200_number_of_islands solution = new Q200_number_of_islands();
        char[][] input = new char[][]{
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int result = solution.numIslands(input);
        assertEquals(0, result);
    }

    @Test
    void testSmall1Island() {
        Q200_number_of_islands solution = new Q200_number_of_islands();
        char[][] input = new char[][]{
                {'1'},
        };
        int result = solution.numIslands(input);
        assertEquals(1, result);
    }

    @Test
    void testSmall0Island() {
        Q200_number_of_islands solution = new Q200_number_of_islands();
        char[][] input = new char[][]{
                {'0'},
        };
        int result = solution.numIslands(input);
        assertEquals(0, result);
    }
}