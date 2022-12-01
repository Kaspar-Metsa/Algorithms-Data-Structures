package dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Q55_Jump_GameTest {

    @Test
    void test1() {
        Q55_Jump_Game solution = new Q55_Jump_Game();
        int[] inputNums = new int[]{2, 3, 1, 1, 4};
        boolean result = solution.canJump(inputNums);
        assertTrue(result);
    }

    @Test
    void test2() {
        Q55_Jump_Game solution = new Q55_Jump_Game();
        int[] inputNums = new int[]{3, 2, 1, 0, 4};
        boolean result = solution.canJump(inputNums);
        assertFalse(result);
    }
}