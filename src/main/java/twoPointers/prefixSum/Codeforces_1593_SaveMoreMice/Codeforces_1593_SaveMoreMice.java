package twoPointers.prefixSum.Codeforces_1593_SaveMoreMice;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Codeforces_1593_SaveMoreMice {
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
//        final var cin = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/km/Documents/Projects/leetcode/src/main/java/twoPointers/prefixSum/Codeforces_1593_SaveMoreMice/input.txt")));
//        final var cout = new BufferedOutputStream(new FileOutputStream("/Users/km/Documents/Projects/leetcode/src/main/java/twoPointers/prefixSum/Codeforces_1593_SaveMoreMice/output.txt"));

        final var numberOfTestCasesLine = nextLine(cin);
        final var numberOfTestcases = numberOfTestCasesLine.nextInt();
        for (int i = 0; i < numberOfTestcases; i++) {
            final var firstLine = nextLine(cin);
            final var totalDistance = firstLine.nextInt();
            final var numberOfMice = firstLine.nextInt();
            final var sequenceLine = nextLine(cin);

            List<Integer> miceCoordinatesInput = new ArrayList<>();
            for (int j = 0; j < numberOfMice; j++) {
                miceCoordinatesInput.add(sequenceLine.nextInt());
            }

            Codeforces_1593_SaveMoreMice solution = new Codeforces_1593_SaveMoreMice();
            int output = solution.methodName(totalDistance, miceCoordinatesInput);
            cout.write(to_bytes(output));
            cout.write(endl);

        }
        cout.flush();
    }

    public Integer methodName(int totalDistance, List<Integer> miceCoordinatesInput) {
        List<Integer> sortedMiceCoordinates = miceCoordinatesInput.stream().map(coordinate -> totalDistance - coordinate).sorted().collect(Collectors.toList());
        List<Long> prefixSumArray = new ArrayList<>();
        prefixSumArray.add((long) sortedMiceCoordinates.get(0));

        for (int i = 1; i < sortedMiceCoordinates.size(); i++) {
            prefixSumArray.add(prefixSumArray.get(i - 1) + sortedMiceCoordinates.get(i));
        }

        long left = -1;
        long right = prefixSumArray.size();

        while (left + 1 < right) {
            long mid = (left + right) / 2;

            if (totalDistance > prefixSumArray.get((int) mid)) {
                left = mid;
            }
            if (totalDistance <= prefixSumArray.get((int) mid)) {
                right = mid;
            }
        }

        return (int) right;
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
