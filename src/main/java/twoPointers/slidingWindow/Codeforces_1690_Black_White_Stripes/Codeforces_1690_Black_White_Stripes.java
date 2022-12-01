package twoPointers.slidingWindow.Codeforces_1690_Black_White_Stripes;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Codeforces_1690_Black_White_Stripes {
    /*
        Test case#1
            input XXX
            output XXX
        Test case#2
            input XXX
            output XXX
    */

    private final static byte[] space = to_bytes(" ");
    private final static byte[] endl = to_bytes("\n");

    private static tokens nextLine(BufferedReader cin) {
        String line = null;
        try {
            line = cin.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new tokens(line);
    }

    private static byte[] to_bytes(String s) {
        return s.getBytes();
    }

    private static byte[] to_bytes(Integer x) {
        return to_bytes(x.toString());
    }

    public static void main(String[] args) throws IOException, FileNotFoundException {
        final var cin = new BufferedReader(new InputStreamReader(System.in));
        final var cout = new BufferedOutputStream(System.out);
//        final var cin = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/km/Documents/Projects/leetcode/src/main/java/twoPointers/slidingWindow/Codeforces_1690_Black_White_Stripes/input.txt")));
//        final var cout = new BufferedOutputStream(new FileOutputStream("/Users/km/Documents/Projects/leetcode/src/main/java/twoPointers/slidingWindow/Codeforces_1690_Black_White_Stripes/output.txt"));

        final var numberOfTestCasesLine = nextLine(cin);
        final var numberOfTestcases = numberOfTestCasesLine.nextInt();
        for (int i = 0; i < numberOfTestcases; i++) {
            final var lengtOfSequenceLine = nextLine(cin);
            final var lengthOfSequence = lengtOfSequenceLine.nextInt();
            final var segmentLength = lengtOfSequenceLine.nextInt();
            final var sequenceLine = nextLine(cin);
            Codeforces_1690_Black_White_Stripes solution = new Codeforces_1690_Black_White_Stripes();
            int output = solution.blackAndWhiteStripes(sequenceLine.nextStr(), segmentLength);
            cout.write(to_bytes(output));
            cout.write(space);
            cout.write(endl);
        }
        cout.flush();
    }

    public Integer blackAndWhiteStripes(String input, int windowSize) {
        int left = 0;
        int right = windowSize - 1;

        int currentAnswer = 0;
        for (int i = 0; i < windowSize; i++) {
            char c = input.charAt(i);
            if (c == 'W') {
                currentAnswer++;
            }
        }
        int minimumAnswer = currentAnswer;

        while (right < input.length() - 1) {
            char leftChar = input.charAt(left);
            if (leftChar == 'W') {
                currentAnswer--;
            }
            left++;
            right++;
            char rightChar = input.charAt(right);
            if (rightChar == 'W') {
                currentAnswer++;
            }
            minimumAnswer = Math.min(minimumAnswer, currentAnswer);
        }
        return minimumAnswer;
    }

    private static final class tokens extends LinkedList<String> {
        tokens(String line) {
            super(new LinkedList<>());
            for (var token : line.split(" "))
                add(token);
        }

        int nextInt() {
            return Integer.parseInt(remove());
        }

        String nextStr() {
            return remove();
        }
    }
}
