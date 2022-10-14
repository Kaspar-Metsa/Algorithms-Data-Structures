package twoPointers.slidingWindow.Codeforces_1462_Favorite_Sequence;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Codeforces_1462_Favorite_Sequence {
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
//        final var cin = new BufferedReader(new InputStreamReader(System.in));
//        final var cout = new BufferedOutputStream(System.out);
        final var cin = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/km/Documents/Projects/leetcode/src/main/java/twoPointers/slidingWindow/Codeforces_1462_Favorite_Sequence/input.txt")));
        final var cout = new BufferedOutputStream(new FileOutputStream("/Users/km/Documents/Projects/leetcode/src/main/java/twoPointers/slidingWindow/Codeforces_1462_Favorite_Sequence/output.txt"));

        final var numberOfTestCasesLine = nextLine(cin);
        final var numberOfTestcases = numberOfTestCasesLine.nextInt();
        for (int i = 0; i < numberOfTestcases; i++) {
            final var lengtOfSequenceLine = nextLine(cin);
            final var lengthOfSequence = lengtOfSequenceLine.nextInt();
            final var sequenceLine = nextLine(cin);

            List<Integer> input = new ArrayList<>();
            for (int j = 0; j < lengthOfSequence; j++) {
                input.add(sequenceLine.nextInt());
            }

            Codeforces_1462_Favorite_Sequence solution = new Codeforces_1462_Favorite_Sequence();
            List<Integer> output = solution.favoriteSequence(input);
            for (int w = 0; w < output.size(); w++) {
                cout.write(to_bytes(output.get(w)));
                cout.write(space);
            }
            if (i != numberOfTestcases - 1) {
                cout.write(endl);

            }
        }
        cout.flush();
    }

    public List<Integer> favoriteSequence(List<Integer> input) {
        List<Integer> result = new ArrayList<>();

        int left = 0;
        int right = input.size() - 1;

        while (true) {
            if (left == right) {
                result.add(input.get(left));
                break;
            } else if (left + 1 == right) {
                result.add(input.get(left));
                result.add(input.get(right));
                break;
            }
            result.add(input.get(left));
            result.add(input.get(right));

            left++;
            right--;
        }
        return result;
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