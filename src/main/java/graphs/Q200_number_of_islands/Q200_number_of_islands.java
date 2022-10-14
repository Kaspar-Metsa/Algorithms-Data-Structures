package graphs.Q200_number_of_islands;

public class Q200_number_of_islands {

    private static int[][] DIRECTIONS
            = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private Coordinate getNextCoordinate(
            int row, int col, int i, int j) {
        return new Coordinate(row + i, col + j);
    }

    public int solve(char[][] grid) {
        Maze maze = new Maze(grid);
        int[] numberOfislands = new int[]{0};
        for (int i = 0; i < maze.getGrid().length; i++) {
            for (int j = 0; j < maze.getGrid()[0].length; j++) {
                if (!maze.isVisited(i, j) && maze.isIsland(i, j)) {
                    explore(maze, i, j);
                    numberOfislands[0]++;
                }
            }
        }

        return numberOfislands[0];
    }

    private void explore(Maze maze, int row, int col) {
        if (row < 0 || col < 0 || row >= maze.getGrid().length || col >= maze.getGrid()[0].length || !maze.isIsland(row, col) || maze.isVisited(row, col)) {
            return;
        }
        maze.setVisited(row, col);

        for (int[] direction : DIRECTIONS) {
            Coordinate coordinate = getNextCoordinate(
                    row, col, direction[0], direction[1]);
            explore(maze, coordinate.getX(), coordinate.getY());
        }
    }

    public int numIslands(char[][] grid) {
        return solve(grid);
    }
}

class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

class Maze {
    char[][] grid;
    boolean[][] visited;

    public Maze(char[][] grid) {
        this.grid = grid;
        visited = new boolean[grid.length][grid[0].length];
    }

    boolean isIsland(int row, int column) {
        return grid[row][column] == '1';
    }

    boolean isVisited(int row, int column) {
        return visited[row][column];
    }

    void setVisited(int row, int column) {
        visited[row][column] = true;
    }

    public char[][] getGrid() {
        return grid;
    }
}