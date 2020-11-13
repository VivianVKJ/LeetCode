package DP;

public class champagneTower {
    public static void main(String[] args) {
        int poured = 100000009;
        int query_row = 33;
        int query_glass = 17;
        System.out.println(champagneTower(poured, query_row, query_glass));
    }

    public static double champagneTower(int poured, int query_row, int query_glass) {
        double[][] t = new double[101][101];
        t[0][0] = poured;
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (t[i][j] > 1) {
                    t[i + 1][j] += (t[i][j] - 1) / 2.0;
                    t[i + 1][j + 1] += (t[i][j] - 1) / 2.0;
                    t[i][j] = 1.0;
                }
            }
        }
        return Math.min(1, t[query_row][query_glass]);
    }
}
