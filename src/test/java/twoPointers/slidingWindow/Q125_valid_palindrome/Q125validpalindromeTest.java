package twoPointers.slidingWindow.Q125_valid_palindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q125validpalindromeTest {

    @Test
    void test1() {
        Q125_valid_palindrome solution = new Q125_valid_palindrome();
        boolean result = solution.isPalindrome("asa");
        assertEquals(true, result);
    }

    @Test
    void test6() {
        Q125_valid_palindrome solution = new Q125_valid_palindrome();
        boolean result = solution.isPalindrome("assa");
        assertEquals(true, result);
    }

    @Test
    void test7() {
        Q125_valid_palindrome solution = new Q125_valid_palindrome();
        boolean result = solution.isPalindrome("asbsa");
        assertEquals(true, result);
    }

    @Test
    void test2() {
        Q125_valid_palindrome solution = new Q125_valid_palindrome();
        boolean result = solution.isPalindrome("A man, a plan, a canal: Panama");
        assertEquals(true, result);
    }

    @Test
    void test3() {
        Q125_valid_palindrome solution = new Q125_valid_palindrome();
        boolean result = solution.isPalindrome("race a car");
        assertEquals(false, result);
    }

    @Test
    void test4() {
        Q125_valid_palindrome solution = new Q125_valid_palindrome();
        boolean result = solution.isPalindrome(" ");
        assertEquals(true, result);
    }
}