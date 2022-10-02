package trees.Q200_numberOfIslands;

import java.util.ArrayDeque;
import java.util.Queue;

public class Q200_numberOfIslands_BFS {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> landQueue = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    landQueue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    bfs(grid, landQueue, visited);
                    count++;
                }
            }
        }
        return count;
    }

    int[][] dirs = {
            {0, 1},     // Right
            {1, 0},     // Down
            {0, -1},    // Left
            {-1, 0}     // Up
    };

    private void bfs(char[][] grid, Queue<int[]> landQueue, boolean[][] visited) {
        while (!landQueue.isEmpty()) {
            int[] curNode = landQueue.poll();
            for (int[] dir : dirs) {
                int x = curNode[0] + dir[0];
                int y = curNode[1] + dir[1];

                if (isWithinBounds(grid, x, y) || visited[x][y] || grid[x][y] == '0') continue;

                visited[x][y] = true;
                landQueue.offer(new int[]{x, y});
            }
        }
    }

    private boolean isWithinBounds(char[][] grid, int x, int y) {
        return x < 0 || x >= grid.length || y < 0 || y >= grid[0].length;
    }
}
