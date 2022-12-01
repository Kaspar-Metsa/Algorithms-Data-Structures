package twoPointers.prefixSum.Codeforces_1345_CardConstructions;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Codeforces_1593_CardConstructions {
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
//        final var cin = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/km/Documents/Projects/leetcode/src/main/java/twoPointers/prefixSum/Codeforces_1345_CardConstructions/input.txt")));
//        final var cout = new BufferedOutputStream(new FileOutputStream("/Users/km/Documents/Projects/leetcode/src/main/java/twoPointers/prefixSum/Codeforces_1345_CardConstructions/output.txt"));

        final var numberOfTestCasesLine = nextLine(cin);
        final var numberOfTestcases = numberOfTestCasesLine.nextInt();
        for (int i = 0; i < numberOfTestcases; i++) {
            final var firstLine = nextLine(cin);
            final var numberOfCards = firstLine.nextInt();
            Codeforces_1593_CardConstructions solution = new Codeforces_1593_CardConstructions();
            int output = solution.methodName(numberOfCards);
            cout.write(to_bytes(output));
            cout.write(endl);

        }
        cout.flush();
    }

    public Integer methodName(int numberOfCards) {
        List<Integer> prefixArray = new ArrayList<>();
        prefixArray.add(0);
        prefixArray.add(2);
        prefixArray.add(7);
        for (int i = 3; numberOfCards >= prefixArray.get(prefixArray.size() - 1); i++) {
            prefixArray.add(prefixArray.get(i - 1) + (prefixArray.get(i - 1) - prefixArray.get(i - 2) + 3));
        }

        int answerCounter = 0;
        while (numberOfCards >= 2) {
            long left = -1;
            long right = prefixArray.size();
            while (left + 1 < right) {
                long mid = (left + right) / 2;

                if (numberOfCards >= prefixArray.get((int) mid)) {
                    left = mid;
                }
                if (numberOfCards < prefixArray.get((int) mid)) {
                    right = mid;
                }
            }
            numberOfCards = numberOfCards - prefixArray.get((int) left);
            answerCounter++;
        }
        return answerCounter;
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
    }
}
