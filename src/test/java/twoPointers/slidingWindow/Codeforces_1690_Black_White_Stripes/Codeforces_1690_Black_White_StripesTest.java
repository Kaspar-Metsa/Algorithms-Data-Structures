package twoPointers.slidingWindow.Codeforces_1690_Black_White_Stripes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Codeforces_1690_Black_White_StripesTest {

    @Test
    void test1() {
        Codeforces_1690_Black_White_Stripes solution = new Codeforces_1690_Black_White_Stripes();
        Integer result = solution.blackAndWhiteStripes("BBWBW", 3);
        assertEquals(1, result);
    }

    @Test
    void test2() {
        Codeforces_1690_Black_White_Stripes solution = new Codeforces_1690_Black_White_Stripes();
        Integer result = solution.blackAndWhiteStripes("WWWBWWBWWBBW", 3);
        assertEquals(1, result);
    }
}