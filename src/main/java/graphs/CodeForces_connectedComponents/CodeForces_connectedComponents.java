package graphs.CodeForces_connectedComponents;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public final class CodeForces_connectedComponents {
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

//        final var cin = new BufferedReader(new InputStreamReader(System.in));
//        final var cout = new BufferedOutputStream(System.out);
        final var cin = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/km/Documents/Projects/leetcode/src/main/java/graphs/CodeForces_connectedComponents/input.txt")));
        final var cout = new BufferedOutputStream(new FileOutputStream("/Users/km/Documents/Projects/leetcode/src/main/java/graphs/CodeForces_connectedComponents/output.txt"));

        final var input = nextLine(cin);

        final var numberOfVertices = input.nextInt();
        final var numberOfEdges = input.nextInt();

        Graph g = new Graph(numberOfVertices);

        for (int i = 1; i <= numberOfVertices; i++) {
            for (int j = 1; j <= numberOfVertices; j++) {
                if (i != j) {
                    g.setTo1(i, j);
                }
            }
        }

        for (int i = 0; i < numberOfEdges; i++) {
            final var edgeLine = nextLine(cin);
            final var source = edgeLine.nextInt();
            final var destination = edgeLine.nextInt();
            g.setTo0(source, destination);
        }
        CodeForces_connectedComponents_Implementation solution = new CodeForces_connectedComponents_Implementation();
        List<Integer> answer = solution.getConnectedComponentsCountAndSizes(g.getAdjMatrix(), numberOfVertices);

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


class CodeForces_connectedComponents_Implementation {
    private static void traverseDFS(int[][] adjMatrix, int curVertex, boolean[] visited) {
        visited[curVertex] = true;
        for (int vertex : adjMatrix[curVertex]) {
            if (!visited[vertex]) {
                traverseDFS(adjMatrix, vertex, visited);
            }
        }
    }

    /*
        Test case#1
            input XXX
            output XXX
        Test case#2
            input XXX
            output XXX
    */
    public List<Integer> getConnectedComponentsCountAndSizes(int[][] adjMatrix, int vertices) {
//        boolean[] visited = new boolean[vertices+1];
//        int componentCount = 0;
        List<Integer> result = printBFS(adjMatrix);

//        return new ArrayList<>(Arrays.asList(componentCount, 2, 3));
        return result;
    }

    public List<Integer> printDFS(int[][] adj_mat) {
        int v = adj_mat.length;
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
                DFSHelper(adj_mat, visited, i, componentSize);
                answer.add(componentSize[0] + 1);
            }
        }
        return answer;
    }

    private void DFSHelper(int[][] adj_mat, boolean[] visited, int sv, int[] componentSize) {
        visited[sv] = true;
        int v = adj_mat.length;

        for (int i = 0; i < v; i++) {
            if (adj_mat[sv][i] == 1 && !visited[i]) {
                componentSize[0]++;
                DFSHelper(adj_mat, visited, i, componentSize);
            }
        }
    }

    public List<Integer> printBFS(int[][] adj_mat) {
        int v = adj_mat.length;
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

    private void BFSHelper(int[][] adj_mat, boolean[] visited, int sv, int[] componentSize) {
        Queue<Integer> queue = new LinkedList<>();
        visited[sv] = true;
        int v = adj_mat.length;
        queue.offer(sv);
        while (!queue.isEmpty()) {
            int polled = queue.poll();
//            System.out.println(polled);
            for (int i = 0; i < v; i++) {
                if (adj_mat[polled][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    componentSize[0]++;
                }
            }
        }
    }
}


class Graph {
    private int adjMatrix[][];
    private int numVertices;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices + 1][numVertices + 1];
    }

    public void setTo1(int i, int j) {
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    public void setTo0(int i, int j) {
        adjMatrix[i][j] = 0;
        adjMatrix[j][i] = 0;
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }
}