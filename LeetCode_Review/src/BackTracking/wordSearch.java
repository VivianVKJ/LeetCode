package BackTracking;

public class wordSearch {

    static int[] dir = {-1, 0, 1, 0, -1};

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board, "SEE") ? "true" : "false");
    }

    public static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (board[i][j] == word.charAt(0))
                    if (search(board, visited, i, j, word, 0)) return true;
        return false;
    }

    public static boolean search(char[][] board, boolean[][] visited, int x, int y, String word, int curr) {
        if (curr == word.length()) return true;
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length ||
                visited[x][y] || word.charAt(curr) != board[x][y]) return false;
        visited[x][y] = true;

        boolean ret = false;
        for (int d = 0; d < 4; d++) {
            int xx = x + dir[d], yy = y + dir[d + 1];
            ret = ret || search(board, visited, xx, yy, word, curr + 1);
        }
        if (ret == true) return true;
        visited[x][y] = false;
        return ret;
    }
}
