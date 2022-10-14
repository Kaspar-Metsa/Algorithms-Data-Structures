package twoPointers.slidingWindow.Codeforces_381_Sereja_Dima;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Codeforces_381_Sereja_Dima {
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
//        final var cin = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/km/Documents/Projects/leetcode/src/main/java/twoPointers/slidingWindow/Codeforces_381_Sereja_Dima/input.txt")));
//        final var cout = new BufferedOutputStream(new FileOutputStream("/Users/km/Documents/Projects/leetcode/src/main/java/twoPointers/slidingWindow/Codeforces_381_Sereja_Dima/output.txt"));

        final var numberOfCardsLine = nextLine(cin);
        final var numberOfCards = numberOfCardsLine.nextInt();
        final var cardsLine = nextLine(cin);
        List<Integer> input = new ArrayList<>();
        for (int j = 0; j < numberOfCards; j++) {
            input.add(cardsLine.nextInt());
        }
        Codeforces_381_Sereja_Dima solution = new Codeforces_381_Sereja_Dima();
        List<Integer> output = solution.serejaDima(input);
        cout.write(to_bytes(output.get(0)));
        cout.write(space);
        cout.write(to_bytes(output.get(1)));
        cout.write(endl);
        cout.flush();
    }

    public List<Integer> serejaDima(List<Integer> input) {
        List<Integer> result = new ArrayList<>();

        Integer serejaSum = 0;
        Integer dimaSum = 0;

        boolean serejaTurn = true;

        int left = 0;
        int right = input.size() - 1;

        while (true) {

            if (input.get(left) > input.get(right)) {
                if (serejaTurn) {
                    serejaSum += input.get(left);
                    if (left == right) {
                        break;
                    }
                    serejaTurn = false;
                } else {
                    dimaSum += input.get(left);
                    if (left == right) {
                        break;
                    }
                    serejaTurn = true;
                }
                left++;
            } else {
                if (serejaTurn) {
                    serejaSum += input.get(right);
                    if (left == right) {
                        break;
                    }
                    serejaTurn = false;
                } else {
                    dimaSum += input.get(right);
                    if (left == right) {
                        break;
                    }
                    serejaTurn = true;
                }
                right--;
            }

        }
        result.add(serejaSum);
        result.add(dimaSum);

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
