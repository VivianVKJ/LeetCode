package DP;

public class PalindromePartitioning_II {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(minCut(s));
    }

    public static int minCut(String s) {
        int n = s.length();
        boolean[][] palindorme = new boolean[n][n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = n;
            for (int j = 0; j < n; j++) palindorme[i][j] = true;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j - i >= 2) {
                    if (s.charAt(i) == s.charAt(j) && palindorme[i - 1][j + 1])
                        palindorme[i][j] = true;
                    else palindorme[i][j] = false;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (palindorme[0][i]) {
                dp[i] = 0;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (palindorme[j + 1][i])
                    dp[i] = Math.min(dp[i], dp[j + 1]);
            }
        }
        return dp[n - 1];
    }

    public static boolean isValid(String sub) {
        for (int i = 0, j = sub.length() - 1; i < j; i++, j--) {
            if (sub.charAt(i) != sub.charAt(j))
                return false;
        }
        return true;
    }
}
