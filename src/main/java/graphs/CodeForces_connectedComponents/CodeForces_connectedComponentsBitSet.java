package graphs.CodeForces_connectedComponents;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//https://codeforces.com/blog/entry/97203
public class CodeForces_connectedComponentsBitSet {
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

    private static byte[] to_bytes(Long x) {
        return to_bytes(x.toString());
    }

    private static byte[] to_bytes(String f, Double x) {
        return to_bytes(String.format(f, x));
    }

    private static byte[] to_bytes(BigInteger x) {
        return to_bytes(x.toString());
    }

    public static void main(String[] args) throws IOException {

        final var cin = new BufferedReader(new InputStreamReader(System.in));
        final var cout = new BufferedOutputStream(System.out);
//        final var cin = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/km/Documents/Projects/leetcode/src/main/java/graphs/CodeForces_connectedComponents/input.txt")));
//        final var cout = new BufferedOutputStream(new FileOutputStream("/Users/km/Documents/Projects/leetcode/src/main/java/graphs/CodeForces_connectedComponents/output.txt"));

        final var input = nextLine(cin);

        final var numberOfVertices = input.nextInt();
        final var numberOfEdges = input.nextInt();

        MatrixBuilder bmat = new MatrixBuilder(numberOfVertices, numberOfVertices);


        for (int i = 1; i <= numberOfVertices; i++) {
            for (int j = 1; j <= numberOfVertices; j++) {
                if (i != j) {
                    bmat.set(i, j);
                    bmat.set(j, i);
                }
            }
        }

        for (int i = 0; i < numberOfEdges; i++) {
            final var edgeLine = nextLine(cin);
            final var source = edgeLine.nextInt();
            final var destination = edgeLine.nextInt();
            bmat.clear(source, destination);
            bmat.clear(destination, source);
        }
        CodeForces_connectedComponents_Implementation_BitSet solution = new CodeForces_connectedComponents_Implementation_BitSet();
        List<Integer> answer = solution.getConnectedComponentsCountAndSizes(bmat, numberOfVertices);

        cout.write(to_bytes(answer.remove(0)));
        cout.write(endl);

        Collections.sort(answer);
        for (int i = 0; i < answer.size(); i++) {
            cout.write(to_bytes(answer.get(i)));
            cout.write(space);
        }
        cout.flush();
    }

    private static final class tokens extends LinkedList<String> {
        tokens(String line) {
            super(new LinkedList<String>());
            for (var token : line.split(" "))
                add(token);
        }

        String nextStr() {
            return remove();
        }

        int nextInt() {
            return Integer.parseInt(remove());
        }

        long nextLong() {
            return Long.parseLong(remove());
        }

        double nextDbl() {
            return Double.parseDouble(remove());
        }

        BigInteger nextBigInt() {
            return new BigInteger(remove());
        }
    }
}


class CodeForces_connectedComponents_Implementation_BitSet {
    private static void traverseDFS(int[][] adjMatrix, int curVertex, boolean[] visited) {
        visited[curVertex] = true;
        for (int vertex : adjMatrix[curVertex]) {
            if (!visited[vertex]) {
                traverseDFS(adjMatrix, vertex, visited);
            }
        }
    }

    public List<Integer> getConnectedComponentsCountAndSizes(MatrixBuilder bmat, int vertices) {
        List<Integer> result = printBFS(bmat);
        return result;
    }

    public List<Integer> printBFS(MatrixBuilder adj_mat) {
        int v = adj_mat.bitArray.length;
        boolean[] visited = new boolean[v];
        List<Integer> answer = new ArrayList<>();

        for (int i = 1; i < v; i++) {
            if (!visited[i]) {
                if (answer.isEmpty()) {
                    answer.add(1);
                } else {
                    answer.set(0, answer.get(0) + 1);
                }
                int[] componentSize = new int[]{0};
                BFSHelper(adj_mat, visited, i, componentSize);
                answer.add(componentSize[0] + 1);
            }
        }
        return answer;
    }

    private void BFSHelper(MatrixBuilder adj_mat, boolean[] visited, int sv, int[] componentSize) {
        Queue<Integer> queue = new LinkedList<>();
        visited[sv] = true;
        int v = adj_mat.bitArray.length;
        queue.offer(sv);
        while (!queue.isEmpty()) {
            int polled = queue.poll();
            for (int i = 0; i < v; i++) {
                if (adj_mat.get(polled, i) && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    componentSize[0]++;
                }
            }
        }
    }
}

class MatrixBuilder {
    public BitSet[] bitArray;

    public MatrixBuilder(int rows, int cols) {
        int actualRows = rows + 1;
        int actualCols = cols + 1;
        bitArray = new BitSet[actualRows];

        int i = 1;

        while (i < actualRows) {
            bitArray[i] = new BitSet(actualCols);
            i++;
        }
    }

    public void clear(int r, int c) {
        bitArray[r].clear(c);
    }

    public boolean get(int r, int c) {
        return bitArray[r].get(c);
    }

    public void set(int r, int c) {
        bitArray[r].set(c);
    }
}