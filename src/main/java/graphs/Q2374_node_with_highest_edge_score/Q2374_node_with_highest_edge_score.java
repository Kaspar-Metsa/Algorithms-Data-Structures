package graphs.Q2374_node_with_highest_edge_score;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q2374_node_with_highest_edge_score {
    /*
        Questions:
            1) Can a vertix have an edge with itself? No
            2) Is n==edges.length? Yes
            3) Max number of vertices? 10 000
            4) So one node can have only 1 outgoing edge but multpiple incoming? Yes
        Test case#1
            input [1,0,0,0,0,7,7,5]
            output 7
        Test case#2
            input [2,0,0,2]
            output 0
    */
    public int edgeScore(int[] edges) {
        Map<Integer, Integer> adjList = new HashMap<>();
        Map<Integer, Integer> edgesIncoming = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            adjList.put(i, edges[i]);
            edgesIncoming.put(i, 0);
        }
        List<String> visited = new ArrayList<>(Collections.nCopies(adjList.size(), "NOT_VISITED"));
        int[] result = new int[]{-1};
        for (int i = 0; i < adjList.size(); i++) {
            if (visited.get(i).equals("NOT_VISITED")) {
                visit(i, adjList, edgesIncoming, -1, visited, result);
            }
        }
        return result[0];
    }

    private void visit(int i, Map<Integer, Integer> adjList, Map<Integer, Integer> edgesIncoming, int parent, List<String> visited, int[] result) {
        if (parent != -1) {
            int newSum = edgesIncoming.get(i) + parent;
            edgesIncoming.put(i, newSum);
            if (result[0] == -1 || newSum > edgesIncoming.get(result[0])) {
                result[0] = i;
            } else if (newSum == edgesIncoming.get(result[0])) {
                result[0] = Math.min(result[0], i);
            }
        }
        if (visited.get(i).equals("NOT_VISITED")) {
            visited.set(i, "VISITED");
            visit(adjList.get(i), adjList, edgesIncoming, i, visited, result);
        }
    }
}