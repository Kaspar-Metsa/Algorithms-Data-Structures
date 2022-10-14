package twoPointers.slidingWindow.Codeforces_1462_Favorite_Sequence;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Codeforces_1462_Favorite_SequenceTest {

    @Test
    void test1() {
        Codeforces_1462_Favorite_Sequence solution = new Codeforces_1462_Favorite_Sequence();
        List<Integer> result = solution.favoriteSequence(new ArrayList<>(Arrays.asList(3, 4, 5, 2, 9, 1, 1)));
        assertEquals(new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2)), result);
    }

    @Test
    void test2() {
        Codeforces_1462_Favorite_Sequence solution = new Codeforces_1462_Favorite_Sequence();
        List<Integer> result = solution.favoriteSequence(new ArrayList<>(Arrays.asList(9, 2, 7, 1)));
        assertEquals(new ArrayList<>(Arrays.asList(9, 1, 2, 7)), result);
    }

    @Test
    void test3() {
        Codeforces_1462_Favorite_Sequence solution = new Codeforces_1462_Favorite_Sequence();
        List<Integer> result = solution.favoriteSequence(new ArrayList<>(Arrays.asList(8, 4, 3, 1, 2, 7, 8, 7, 9, 4, 2)));
        assertEquals(new ArrayList<>(Arrays.asList(8, 2, 4, 4, 3, 9, 1, 7, 2, 8, 7)), result);
    }

    @Test
    void test4() {
        Codeforces_1462_Favorite_Sequence solution = new Codeforces_1462_Favorite_Sequence();
        List<Integer> result = solution.favoriteSequence(new ArrayList<>(List.of(42)));
        assertEquals(new ArrayList<>(List.of(42)), result);
    }

    @Test
    void test5() {
        Codeforces_1462_Favorite_Sequence solution = new Codeforces_1462_Favorite_Sequence();
        List<Integer> result = solution.favoriteSequence(new ArrayList<>(Arrays.asList(11, 7)));
        assertEquals(new ArrayList<>(Arrays.asList(11, 7)), result);
    }

    @Test
    void test6() {
        Codeforces_1462_Favorite_Sequence solution = new Codeforces_1462_Favorite_Sequence();
        List<Integer> result = solution.favoriteSequence(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1)));
        assertEquals(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1)), result);
    }
}