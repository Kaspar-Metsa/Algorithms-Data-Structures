package trees.Q200_numberOfIslands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q200_numberOfIslands_BFSTest {

    Q200_numberOfIslands_BFS q200_numberOfIslands_bfs;

    @BeforeEach
    void beforeEach() {
        q200_numberOfIslands_bfs = new Q200_numberOfIslands_BFS();
    }

    @Test
    void oneIsland() {
        char[][] input = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int actual = q200_numberOfIslands_bfs.numIslands(input);
        assertEquals(1, actual);
    }
    @Test
    void twoIslands() {
        char[][] input = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '1'},
                {'0', '0', '0', '1', '1'}
        };
        int actual = q200_numberOfIslands_bfs.numIslands(input);
        assertEquals(2, actual);
    }
    @Test
    void threeIslands() {
        char[][] input = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int actual = q200_numberOfIslands_bfs.numIslands(input);
        assertEquals(3, actual);
    }
    @Test
    void sevenIslands() {
        char[][] input = {
                {'0', '1', '0', '1', '0'},
                {'1', '0', '1', '0', '1'},
                {'0', '1', '1', '1', '0'},
                {'1', '0', '1', '0', '1'}
        };
        int actual = q200_numberOfIslands_bfs.numIslands(input);
        assertEquals(7, actual);
    }

    @Test
    void emptyArrays() {
        char[][] input = {
                {}
        };
        int actual = q200_numberOfIslands_bfs.numIslands(input);
        assertEquals(0, actual);
    }

    @Test
    void multipleEmptyRows() {
        char[][] input = {
                {},
                {},
                {},
                {}
        };
        int actual = q200_numberOfIslands_bfs.numIslands(input);
        assertEquals(0, actual);
    }
    @Test
    void allOnes() {
        char[][] input = {
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'}
        };
        int actual = q200_numberOfIslands_bfs.numIslands(input);
        assertEquals(1, actual);
    }
}