package DFS;

public class numOfIslands {
    public static int[] dir = {1, 0, -1, 0, 1};

    public static int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;

        int n = grid[0].length;
        if (n == 0) return 0;

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    System.out.printf("[%d,%d] ", i, j);
                    DFS(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void DFS(char[][] grid, int x, int y) {
        if (isValid(x, y, grid)) {
            grid[x][y] = '0';
            for (int k = 0; k < 4; k++) {
                DFS(grid, x + dir[k], y + dir[k + 1]);
            }
        }
    }

    public static boolean isValid(int x, int y, char[][] grid) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length)
            return false;
        if (grid[x][y] == '0')
            return false;
        return true;
    }
}
