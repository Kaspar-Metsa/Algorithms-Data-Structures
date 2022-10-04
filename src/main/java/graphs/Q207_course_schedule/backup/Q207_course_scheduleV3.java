package graphs.Q207_course_schedule.backup;

import java.util.ArrayList;
import java.util.List;

public class Q207_course_scheduleV3 {
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

        for (int i = 0; i < numCourses; i++) {

        }
        Graph graph = new Graph();
        for (int[] prerequisite : prerequisites) {
//            adjList.get(prerequisite[1]).add(prerequisite[0]);
            Vertex vertexSource = new Vertex(prerequisite[1]);
            Vertex vertexTarget = new Vertex(prerequisite[0]);
            graph.addVertex(vertexSource);
            graph.addVertex(vertexTarget);
            graph.addEdge(vertexSource, vertexTarget);
        }

        return !hasCycle(graph.getVertices());

//        Map<Integer, List<Integer>> adjList = new HashMap<>();
//        List<String> visited = new ArrayList<>();
//
//        for (int i = 0; i < numCourses; i++) {
//            adjList.put(i, new LinkedList<>());
//        }

//        for (int i = 0; i < adjList.size(); i++) {
//            visited.add("NOT_VISITED");
//        }
//        for (int i = 0; i < adjList.size(); i++) {
//            if (visited.get(i).equals("NOT_VISITED")) {
//                Deque<Integer> stack = new ArrayDeque<>();
//                stack.push(i);
//                visited.set(i, "IN_STACK");
//                boolean[] hasCycle = {false};
//                hasCycleInDFSTree(adjList, stack, visited, hasCycle);
//                if (hasCycle[0]) {
//                    return false;
//                }
//            }
//        }
//        return true;
    }

    public boolean hasCycle(List<Vertex> vertices) {
        for (Vertex vertex : vertices) {
            if (!vertex.isVisited() && hasCycle(vertex)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle(Vertex sourceVertex) {
        sourceVertex.setBeingVisited(true);

        for (Vertex neighbor : sourceVertex.getAdjacencyList()) {
            if (neighbor.isBeingVisited()) {
                // backward edge exists
                return true;
            } else if (!neighbor.isVisited() && hasCycle(neighbor)) {
                return true;
            }
        }

        sourceVertex.setBeingVisited(false);
        sourceVertex.setVisited(true);
        return false;
    }

//    private void hasCycleInDFSTree(Map<Integer, List<Integer>> adjList, Deque<Integer> stack, List<String> visited, boolean[] hasCycle) {
//        for (Integer vertex : adjList.get(stack.peek())) {
//            if (visited.get(vertex).equals("IN_STACK")) {
//                hasCycle[0] = true;
//            } else if (visited.get(vertex).equals("NOT_VISITED")) {
//                stack.push(vertex);
//                visited.set(vertex, "IN_STACK");
//                hasCycleInDFSTree(adjList, stack, visited, hasCycle);
//            }
//        }
//        visited.set(stack.peek(), "DONE");
//        stack.pop();
//    }
}

class Vertex {

    private Integer label;
    private boolean beingVisited;
    private boolean visited;
    private List<Vertex> adjacencyList;

    public Vertex(Integer label) {
        this.label = label;
        this.adjacencyList = new ArrayList<>();
    }

    public void addNeighbor(Vertex adjacent) {
        this.adjacencyList.add(adjacent);
    }

    public Integer getLabel() {
        return label;
    }

    public void setLabel(Integer label) {
        this.label = label;
    }

    public boolean isBeingVisited() {
        return beingVisited;
    }

    public void setBeingVisited(boolean beingVisited) {
        this.beingVisited = beingVisited;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(List<Vertex> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }
}


class Graph {

    private List<Vertex> vertices;

    public Graph() {
        this.vertices = new ArrayList<>();
    }

    public void addVertex(Vertex vertex) {
        this.vertices.add(vertex);
    }

    public void addEdge(Vertex from, Vertex to) {
        from.addNeighbor(to);
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
    }
}