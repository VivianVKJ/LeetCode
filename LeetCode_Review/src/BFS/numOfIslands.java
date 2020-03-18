package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class numOfIslands {
    public static int[] dir = {1, 0, -1, 0, 1};

    public static int numIslands_BFS(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (m == 0) return 0;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    System.out.printf("[%d,%d] ", i, j);
                    Queue<Integer> queue = new LinkedList<>();
                    visited[i][j] = true;
                    queue.offer(i * n + j);

                    while (!queue.isEmpty()) {
                        int cx = queue.peek() / n;
                        int cy = queue.peek() % n;
                        queue.poll();


                        //2 directions
                        for (int k = 0; k < 4; k++) {
                            int nx = cx + dir[k];
                            int ny = cy + dir[k + 1];

                            if (isValid_BFS(nx, ny, grid, visited)) {
                                visited[nx][ny] = true;
                                queue.offer(nx * n + ny);
                            }
                        }
                    }

                }

            }
        }
        return count;
    }

    public static boolean isValid_BFS(int x, int y, char[][] grid, boolean[][] visited) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length)
            return false;
        return grid[x][y] != '0' && !visited[x][y];
    }
}
