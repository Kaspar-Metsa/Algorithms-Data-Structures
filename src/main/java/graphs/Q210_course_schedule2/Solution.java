package graphs.Q210_course_schedule2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    /*
        Test case#1
            input numCourses = 2, prerequisites = [[1,0]]
            output [0,1]
        Test case#2
            input numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
            output [0,2,1,3]
    */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 1) {
            return new int[]{0};
        }
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            List<Integer> adjacencies = new LinkedList<>();
            adjList.put(i, adjacencies);
        }
        for (int[] prerequisite : prerequisites) {
            if (adjList.containsKey(prerequisite[1])) {
                adjList.get(prerequisite[1]).add(prerequisite[0]);
            } else {
                List<Integer> adjacencies = new LinkedList<>();
                adjacencies.add(prerequisite[0]);
                adjList.put(prerequisite[1], adjacencies);
            }
        }
        List<String> visited = new ArrayList<>(Collections.nCopies(adjList.size(), "NOT_VISITED"));
        boolean[] hasCycle = {false};
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = 0; i < adjList.size(); i++) {
            if (visited.get(i).equals("NOT_VISITED")) {
                visit(i, adjList, visited, hasCycle, result);
            }

        }
        if (hasCycle[0]) {
            return new int[]{};
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    private void visit(int i, Map<Integer, List<Integer>> adjList, List<String> visited, boolean[] hasCycle, LinkedList<Integer> result) {
        if (visited.get(i).equals("PERMANENT")) {
            return;
        }
        if (visited.get(i).equals("TEMPORARY")) {
            hasCycle[0] = true;
            return;
        }
        visited.set(i, "TEMPORARY");

        for (Integer node : adjList.get(i)) {
            visit(node, adjList, visited, hasCycle, result);
        }
        visited.set(i, "PERMANENT");
        result.addFirst(i);
    }
}