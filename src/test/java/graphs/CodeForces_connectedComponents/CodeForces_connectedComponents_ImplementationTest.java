package graphs.CodeForces_connectedComponents;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CodeForces_connectedComponents_ImplementationTest {

    @Test
    void test1() {
        int[][] adjMatrix = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 1},
                {0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 1, 0}
        };
        int numberOfVertices = 5;
        CodeForces_connectedComponents_Implementation solution = new CodeForces_connectedComponents_Implementation();
        List<Integer> result = solution.getConnectedComponentsCountAndSizes(adjMatrix, numberOfVertices);
        assertEquals(new ArrayList<>(Arrays.asList(2, 4, 1)), result);
    }

    /*

    1 0

    */
    @Test
    void test2() {
        int[][] adjMatrix = new int[][]{
                {0, 0, 0, 0, 0, 0},
        };
        int numberOfVertices = 1;
        CodeForces_connectedComponents_Implementation solution = new CodeForces_connectedComponents_Implementation();
        List<Integer> result = solution.getConnectedComponentsCountAndSizes(adjMatrix, numberOfVertices);
        assertEquals(new ArrayList<>(Arrays.asList(2, 4, 1)), result);
    }
}