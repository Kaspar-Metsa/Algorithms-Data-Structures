package graphs.Q2360_longest_cycle;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Q2360_longest_cycle {
    /*
        Test case#1
            input [3,3,4,2,3]
            output 3
        Test case#2
            input [2,-1,3,1]
            output -1
    */
    public int longestCycle(int[] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            List<Integer> adjacencies;
            if (edges[i] != -1) {
                adjacencies = new LinkedList<>(List.of(edges[i]));
            } else {
                adjacencies = new LinkedList<>();
            }
            adjList.put(i, adjacencies);
        }
        List<String> visited = new ArrayList<>(Collections.nCopies(adjList.size(), "NOT_VISITED"));
        int[] longestCycle = new int[]{-1};

        for (int i = 0; i < adjList.size(); i++) {
            if (visited.get(i).equals("NOT_VISITED")) {
                Deque<Integer> stack = new ArrayDeque<>();
                stack.push(i);
                visited.set(i, "IN_STACK");
                hasCycleInDFSTree(adjList, stack, visited, longestCycle);
            }
        }
        return longestCycle[0];
    }

    private void hasCycleInDFSTree(Map<Integer, List<Integer>> adjList, Deque<Integer> stack, List<String> visited, int[] longestCycle) {
        for (Integer vertex : adjList.get(stack.peek())) {
            if (visited.get(vertex).equals("IN_STACK")) {
                longestCycle[0] = Math.max(getCycleLength(stack, vertex), longestCycle[0]);
            } else if (visited.get(vertex).equals("NOT_VISITED")) {
                stack.push(vertex);
                visited.set(vertex, "IN_STACK");
                hasCycleInDFSTree(adjList, stack, visited, longestCycle);
            }
        }
        visited.set(stack.peek(), "DONE");
        stack.pop();
    }

    private int getCycleLength(Deque<Integer> stack, Integer vertex) {
        Deque<Integer> innerStack = new ArrayDeque<>();
        innerStack.push(stack.pop());
        int cycleCount = 0;

        do {
            innerStack.push(stack.pop());
        } while (!Objects.equals(innerStack.peek(), vertex));

        do {
            cycleCount += 1;
            stack.push(innerStack.peek());
            innerStack.pop();
        } while (!innerStack.isEmpty());

        return cycleCount;
    }

}