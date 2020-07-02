/*
 * @lc app=leetcode id=323 lang=java
 *
 * [323] Number of Connected Components in an Undirected Graph
 */

// @lc code=start
class Solution {
    int[] father;

    public int countComponents(int n, int[][] edges) {
        father = new int[n];
        for (int i = 0; i < n; i++)
            father[i] = i;
        int comp = n;
        for (int[] e : edges) {
            int fx = find(e[0]);
            int fy = find(e[1]);
            if (fx != fy) {
                father[fx] = fy;
                comp--;
            }
        }
        return comp;
    }

    public int find(int x) {
        if (father[x] == x)
            return x;
        return father[x] = find(father[x]);
    }
}
// @lc code=end
