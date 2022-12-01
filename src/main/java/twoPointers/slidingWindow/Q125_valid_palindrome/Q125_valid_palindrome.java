package twoPointers.slidingWindow.Q125_valid_palindrome;

public class Q125_valid_palindrome {
    /*
        Test case#1
            input XXX
            output XXX
        Test case#2
            input XXX
            output XXX
    */


    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;
        }

        return true;
    }

//    //My solution
//    public boolean isPalindrome(String s) {
//
//        String lowercaseTrimmed = s.toLowerCase().trim().replaceAll("[^A-Za-z0-9]", "");;
//
//        if(lowercaseTrimmed.length()<=1){
//            return true;
//        }
//
//        int left = 0;
//        int right = lowercaseTrimmed.length() - 1;
//
//        if (lowercaseTrimmed.charAt(left) != lowercaseTrimmed.charAt(right)) {
//            return false;
//        }
//
//        while (left != right && left + 1 != right) {
//            left++;
//            right--;
//
//            if (lowercaseTrimmed.charAt(left) != lowercaseTrimmed.charAt(right)) {
//                return false;
//            }
//        }
//
//        return true;
//    }
}