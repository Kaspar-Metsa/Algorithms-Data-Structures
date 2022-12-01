//package graphs.Q743_network_delay_time;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//import java.util.Objects;
//import java.util.Set;
//
//public class Q743_network_delay_time_NOTWORKING {
//    /*
//        https://www.baeldung.com/java-dijkstra
//
//        Questions
//            Can there be multiple identical edges? No
//            Can an edge go from vertex to itself? No
//            Minimum number of nodes? 1
//            Maximum number of nodes? 100
//            Maximum number of edges? 6000
//            What is the maximum weight? 100
//            Is times[i] always equal to 3? yes
//            Can there be cycles in the graph? yes
//    */
//    public int networkDelayTime(int[][] times, int n, int k) {
//
//        Map<Integer, List<List<Integer>>> adjList = new HashMap<>();
//
//        for (int[] time : times) {
//            if (!adjList.containsKey(time[1])) {
//                adjList.put(time[1], new LinkedList<>());
//            }
//
//            if (!adjList.containsKey(time[0])) {
//                List<List<Integer>> adjacenciesWithWeights = new LinkedList<>();
//                List<Integer> adjacencyWithWeight = new ArrayList<>(Arrays.asList(time[1], time[2]));
//                adjacenciesWithWeights.add(adjacencyWithWeight);
//                adjList.put(time[0], adjacenciesWithWeights);
//            } else {
//                List<List<Integer>> existingVertix = adjList.get(time[0]);
//                List<Integer> adjacencyWithWeight = new ArrayList<>(Arrays.asList(time[1], time[2]));
//                existingVertix.add(adjacencyWithWeight);
//            }
//        }
//
//        Graph graph = new Graph();
//
//        Node startingNode = new Node(k);
////        graph.addNode(startingNode);
//        for (Integer key : adjList.keySet()) {
//            Node sourceNode = new Node(key);
//            if(key==k){
//                sourceNode=startingNode;
//            }
//            graph.addNode(sourceNode);
//
//            List<List<Integer>> adjacencies = adjList.get(key);
//            for (List<Integer> adjacency : adjacencies) {
//                if (!adjacency.isEmpty()) {
//                    Node targetNode = new Node(adjacency.get(0));
//                    sourceNode.addDestination(targetNode, adjacency.get(1));
//                }
//            }
//        }
//        Graph answer = Q743_network_delay_time_NOTWORKING.calculateShortestPathFromSource(graph, startingNode);
//        return 0;
//    }
//
//    public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
//        source.setDistance(0);
//
//        Set<Node> settledNodes = new HashSet<>();
//        Set<Node> unsettledNodes = new HashSet<>();
//
//        unsettledNodes.add(source);
//
//        while (unsettledNodes.size() != 0) {
//            Node currentNode = getLowestDistanceNode(unsettledNodes);
//            unsettledNodes.remove(currentNode);
//            for (Map.Entry<Node, Integer> adjacencyPair :
//                    currentNode.getAdjacentNodes().entrySet()) {
//                Node adjacentNode = adjacencyPair.getKey();
//                Integer edgeWeight = adjacencyPair.getValue();
//                if (!settledNodes.contains(adjacentNode)) {
//                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
//                    unsettledNodes.add(adjacentNode);
//                }
//            }
//            settledNodes.add(currentNode);
//        }
//        return graph;
//    }
//
//    private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
//        Node lowestDistanceNode = null;
//        int lowestDistance = Integer.MAX_VALUE;
//        for (Node node : unsettledNodes) {
//            int nodeDistance = node.getDistance();
//            if (nodeDistance < lowestDistance) {
//                lowestDistance = nodeDistance;
//                lowestDistanceNode = node;
//            }
//        }
//        return lowestDistanceNode;
//    }
//
//    private static void calculateMinimumDistance(Node evaluationNode,
//                                                 Integer edgeWeigh, Node sourceNode) {
//        Integer sourceDistance = sourceNode.getDistance();
//        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
//            evaluationNode.setDistance(sourceDistance + edgeWeigh);
//            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
//            shortestPath.add(sourceNode);
//            evaluationNode.setShortestPath(shortestPath);
//        }
//    }
//
//    public static void main(String[] args) {
//        Node nodeA = new Node(1);
//        Node nodeB = new Node(2);
//        Node nodeC = new Node(3);
//        Node nodeD = new Node(4);
//        Node nodeE = new Node(5);
//        Node nodeF = new Node(6);
//
//        nodeA.addDestination(nodeB, 10);
//        nodeA.addDestination(nodeC, 15);
//
//        nodeB.addDestination(nodeD, 12);
//        nodeB.addDestination(nodeF, 15);
//
//        nodeC.addDestination(nodeE, 10);
//
//        nodeD.addDestination(nodeE, 2);
//        nodeD.addDestination(nodeF, 1);
//
//        nodeF.addDestination(nodeE, 5);
//
//        Graph graph = new Graph();
//
//        graph.addNode(nodeA);
//        graph.addNode(nodeB);
//        graph.addNode(nodeC);
//        graph.addNode(nodeD);
//        graph.addNode(nodeE);
//        graph.addNode(nodeF);
//
//        graph = Q743_network_delay_time_NOTWORKING.calculateShortestPathFromSource(graph, nodeA);
//        System.out.println("qq");
//    }
//}
//
//class Graph {
//
//    private Set<Node> nodes = new HashSet<>();
//
//    public void addNode(Node nodeA) {
//        nodes.add(nodeA);
//    }
//
//    public boolean hasNode(Integer nodeLabel) {
//        return nodes.stream().anyMatch(currentNode -> Objects.equals(currentNode.getName(), nodeLabel));
//    }
//}
//
//class Node {
//
//    private Integer name;
//
//    private List<Node> shortestPath = new LinkedList<>();
//
//    private Integer distance = Integer.MAX_VALUE;
//
//    Map<Node, Integer> adjacentNodes = new HashMap<>();
//
//    public void addDestination(Node destination, int distance) {
//        adjacentNodes.put(destination, distance);
//    }
//
//    public Node(Integer name) {
//        this.name = name;
//    }
//
//    public Integer getDistance() {
//        return distance;
//    }
//
//    public void setDistance(Integer distance) {
//        this.distance = distance;
//    }
//
//    public Map<Node, Integer> getAdjacentNodes() {
//        return adjacentNodes;
//    }
//
//    public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
//        this.adjacentNodes = adjacentNodes;
//    }
//
//    public List<Node> getShortestPath() {
//        return shortestPath;
//    }
//
//    public void setShortestPath(List<Node> shortestPath) {
//        this.shortestPath = shortestPath;
//    }
//
//    public Integer getName() {
//        return name;
//    }
//}