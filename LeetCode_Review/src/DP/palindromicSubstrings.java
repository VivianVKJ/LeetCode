package DP;

public class palindromicSubstrings {
    public static void main(String[] args) {
        System.out.println(countSubstrings("aaaaa"));
    }

    public static int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[j][i] = ((s.charAt(i) == s.charAt(j)) && (i - j <= 2 || dp[j + 1][i - 1] == 1)) ? 1 : 0;
                ans += dp[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println(" ");
        }
        return ans;
    }
}
