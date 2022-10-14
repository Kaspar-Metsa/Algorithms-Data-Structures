package twoPointers.slidingWindow.Codeforces_381_Sereja_Dima;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Codeforces_381_Sereja_DimaTest {

    @Test
    void test1() {
        Codeforces_381_Sereja_Dima solution = new Codeforces_381_Sereja_Dima();
        List<Integer> result = solution.serejaDima(new ArrayList<>(Arrays.asList(4, 1, 2, 10)));
        assertEquals(new ArrayList<>(Arrays.asList(12, 5)), result);
    }

    @Test
    void test2() {
        Codeforces_381_Sereja_Dima solution = new Codeforces_381_Sereja_Dima();
        List<Integer> result = solution.serejaDima(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
        assertEquals(new ArrayList<>(Arrays.asList(16, 12)), result);
    }
}