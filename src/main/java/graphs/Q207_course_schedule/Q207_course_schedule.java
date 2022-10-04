package graphs.Q207_course_schedule;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q207_course_schedule {
    /*
        Test case#1
            input numCourses = 2, prerequisites = [[1,0]]
            output true
        Test case#2
            input numCourses = 2, prerequisites = [[1,0],[0,1]]
            output false
    */


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length <= 1) {
            return true;
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

        for (int i = 0; i < adjList.size(); i++) {
            if (visited.get(i).equals("NOT_VISITED")) {
                Deque<Integer> stack = new ArrayDeque<>();
                stack.push(i);
                visited.set(i, "IN_STACK");
                boolean[] hasCycle = {false};
                hasCycleInDFSTree(adjList, stack, visited, hasCycle);
                if (hasCycle[0]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void hasCycleInDFSTree(Map<Integer, List<Integer>> adjList, Deque<Integer> stack, List<String> visited, boolean[] hasCycle) {
        for (Integer vertex : adjList.get(stack.peek())) {
            if (visited.get(vertex).equals("IN_STACK")) {
                hasCycle[0] = true;
            } else if (visited.get(vertex).equals("NOT_VISITED")) {
                stack.push(vertex);
                visited.set(vertex, "IN_STACK");
                hasCycleInDFSTree(adjList, stack, visited, hasCycle);
            }
        }
        visited.set(stack.peek(), "DONE");
        stack.pop();
    }
}