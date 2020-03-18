package BFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class orangesRotting {
    public static int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;
        int[] dir = new int[]{0, 1, 0, -1, 0};
        Queue<Integer> queue = new LinkedList<Integer>();
        HashMap<Integer, Integer> time = new HashMap<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < 0; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(i * n + j);
                    time.put(i * n + j, 0); // start
                }
            }
        while (!queue.isEmpty()) {
            System.out.print(queue.size() + " ");
            int curr = queue.poll();
            int x = curr / n, y = curr % n;
            for (int d = 0; d < 4; d++) {
                int cx = x + dir[d];
                int cy = y + dir[d + 1];
                if (cx >= 0 && cy >= 0 && cx < m && cy < n && grid[cx][cy] == 1) {
                    grid[cx][cy] = 2;
                    queue.offer(cx * n + cy);
                    time.put(cx * n + cy, time.get(curr) + 1);
                    ans = time.get(cx * n + cy);
                }
            }
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < 0; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        return ans;

    }
}
