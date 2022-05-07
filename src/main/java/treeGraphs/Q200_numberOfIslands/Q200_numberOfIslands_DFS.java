package treeGraphs.Q200_numberOfIslands;

public class Q200_numberOfIslands_DFS {
    public int numIslands(char[][] grid) {
        char[][] tempGrid = grid; // To avoid changing array
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;
        for (int i = 0; i < tempGrid.length; i++) {
            for (int j = 0; j < tempGrid[i].length; j++) {
                if (tempGrid[i][j] == '1') {
                    count += 1;
                    callDFS(tempGrid, i, j);
                }
            }
        }
        return count;
    }

    private void callDFS(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') return;

        grid[i][j] = '0';
        callDFS(grid, i - 1, j); //up
        callDFS(grid, i + 1, j); //down
        callDFS(grid, i, j - 1); //left
        callDFS(grid, i, j + 1); //right
    }
}
