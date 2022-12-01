package graphs.Q743_network_delay_time;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Q743_network_delay_time_TLE {
    /*
        Test case#1
            input XXX
            output XXX
        Test case#2
            input XXX
            output XXX
    */
    public int networkDelayTime(int[][] times, int n, int k) {
        long startTime = System.nanoTime();
        Graph_pq dpq = new Graph_pq(n);
        List<List<Node>> adj_list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Node> item = new ArrayList<>();
            adj_list.add(item);
        }
        for (int[] time : times) {
            adj_list.get(time[0] - 1).add(new Node(time[1] - 1, time[2]));
        }
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Total execution time to create adjacency list in millis: "
                + elapsedTime / 1000000);
        long startTime2 = System.nanoTime();
        dpq.algo_dijkstra(adj_list, k - 1);
        long elapsedTime2 = System.nanoTime() - startTime2;
        System.out.println("Function: "
                + elapsedTime2 / 1000000);
        int maxDistance = 0;
        long startTime3 = System.nanoTime();
        for (int distance : dpq.dist) {
            if (distance == Integer.MAX_VALUE) {
                return -1;
            }
            maxDistance = Math.max(maxDistance, distance);
        }
        long elapsedTime3 = System.nanoTime() - startTime3;
        System.out.println("Solution generation: "
                + elapsedTime3 / 1000000);
        return maxDistance;
    }
}


class Graph_pq {
    int[] dist;
    Set<Integer> visited;
    PriorityQueue<Node> pqueue;
    int V; // Number of vertices
    List<List<Node>> adj_list;

    //class constructor
    public Graph_pq(int V) {
        this.V = V;
        dist = new int[V];
        visited = new HashSet<>();
        pqueue = new PriorityQueue<>(V, new Node());
    }

    // Dijkstra's Algorithm implementation
    public void algo_dijkstra(List<List<Node>> adj_list, int src_vertex) {
        this.adj_list = adj_list;

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        // first add source vertex to PriorityQueue
        pqueue.add(new Node(src_vertex, 0));

        // Distance to the source from itself is 0
        dist[src_vertex] = 0;
        while (visited.size() != V) {
            if (pqueue.isEmpty()) {
                break;
            }

            // u is removed from PriorityQueue and has min distance
            int u = pqueue.remove().node;

            // add node to finalized list (visited)
            visited.add(u);
            graph_adjacentNodes(u);
        }
    }

    // this methods processes all neighbours of the just visited node
    private void graph_adjacentNodes(int u) {
        int edgeDistance = -1;
        int newDistance = -1;

        // process all neighbouring nodes of u
        for (int i = 0; i < adj_list.get(u).size(); i++) {
            Node v = adj_list.get(u).get(i);

            //  proceed only if current node is not in 'visited'
            if (!visited.contains(v.node)) {
                edgeDistance = v.cost;
                newDistance = dist[u] + edgeDistance;

                // compare distances
                if (newDistance < dist[v.node])
                    dist[v.node] = newDistance;

                // Add the current vertex to the PriorityQueue
                pqueue.add(new Node(v.node, dist[v.node]));
            }
        }
    }
}

class Main {
    public static void main(String[] arg) {

        PriorityQueue<Node> pqueue = new PriorityQueue<>(3);
        pqueue.add(new Node(2, 2));
        pqueue.add(new Node(1, 1));
        System.out.println(pqueue);
//        int V = 6;
//        int source = 0;
//        // adjacency list representation of graph
//        List<List<Node>> adj_list = new ArrayList<List<Node>>();
//        // Initialize adjacency list for every node in the graph
//        for (int i = 0; i < V; i++) {
//            List<Node> item = new ArrayList<Node>();
//            adj_list.add(item);
//        }
//
//
//        // Input graph edges
//        adj_list.get(0).add(new Node(1, 5));
//        adj_list.get(0).add(new Node(2, 3));
//        adj_list.get(0).add(new Node(3, 2));
//        adj_list.get(0).add(new Node(4, 3));
//        adj_list.get(0).add(new Node(5, 3));
//        adj_list.get(2).add(new Node(1, 2));
//        adj_list.get(2).add(new Node(3, 3));
//        // call Dijkstra's algo method
//        Graph_pq dpq = new Graph_pq(V);
//        dpq.algo_dijkstra(adj_list, source);
//
//        // Print the shortest path from source node to all the nodes
//        System.out.println("The shortest path from source node to other nodes:");
//        System.out.println("Source\t\t" + "Node#\t\t" + "Distance");
//        for (int i = 0; i < dpq.dist.length; i++)
//            System.out.println(source + " \t\t " + i + " \t\t " + dpq.dist[i]);
    }
}

// Node class
class Node implements Comparator<Node> {
    public int node;
    public int cost;

    public Node() {
    } //empty constructor

    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compare(Node node1, Node node2) {
        return Integer.compare(node1.cost, node2.cost);
    }
}