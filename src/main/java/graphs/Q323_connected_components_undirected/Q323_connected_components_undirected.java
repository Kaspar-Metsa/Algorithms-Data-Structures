package graphs.Q323_connected_components_undirected;

public class Q323_connected_components_undirected {
    /*
        Test case#1
            input n = 5, edges = [[0,1],[1,2],[3,4]]
            output 2
        Test case#2
            input n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
            output 1
    */
    public int countComponents(int n, int[][] edges) {

        final var numberOfVertices = n;
        int[][] adjMatrix = new int[numberOfVertices][numberOfVertices];

        for (int[] edge : edges) {
            adjMatrix[edge[0]][edge[1]] = 1;
            adjMatrix[edge[1]][edge[0]] = 1;
        }

        return printDFS(adjMatrix);
    }

    public int printDFS(int[][] adj_mat) {
        int numberOfVertices = adj_mat.length;
        boolean[] visited = new boolean[numberOfVertices];
        int[] answer = new int[]{0};

        for (int i = 0; i < numberOfVertices; i++) {
            if (!visited[i]) {
                DFSHelper(adj_mat, visited, i);
                answer[0]++;
            }
        }
        return answer[0];
    }

    private void DFSHelper(int[][] adj_mat, boolean[] visited, int sv) {
        visited[sv] = true;
        int v = adj_mat.length;

        for (int i = 0; i < v; i++) {
            if (adj_mat[sv][i] == 1 && !visited[i]) {
                DFSHelper(adj_mat, visited, i);
            }
        }
    }
}