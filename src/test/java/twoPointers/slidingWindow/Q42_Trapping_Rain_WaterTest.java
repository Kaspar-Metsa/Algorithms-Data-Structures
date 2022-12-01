package twoPointers.slidingWindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q42_Trapping_Rain_WaterTest {

    @Test
    void trap() {
        Q42_Trapping_Rain_Water solution = new Q42_Trapping_Rain_Water();
        int[] intputNums = new int[]{};
        int result = solution.trap(intputNums);
        assertEquals(-1, result);
    }
}