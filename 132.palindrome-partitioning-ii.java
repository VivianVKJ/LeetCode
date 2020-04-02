/*
 * @lc app=leetcode id=132 lang=java
 *
 * [132] Palindrome Partitioning II
 */

// @lc code=start
class Solution {
    int ans = Integer.MAX_VALUE;

    public int minCut(String s) {
        if (isValid(s))
            return 0;
        backtrack(s, 0, 0);
        return ans;
    }

    public void backtrack(String s, int index, int cut) {
        if (index == s.length()) {
            ans = Math.min(ans, cut);
        }
        for (int i = index; i < s.length(); i++) {
            String temp = s.substring(index, i + 1);
            if (isValid(temp)) {
                backtrack(s, i + 1, (i + 1 == s.length()) ? cut : cut + 1);
            }
        }
    }

    public boolean isValid(String sub) {
        for (int i = 0, j = sub.length() - 1; i < j; i++, j--) {
            // if(sub[i]!=sub[j]) return false;
            if (sub.charAt(i) != sub.charAt(j))
                return false;
        }
        return true;
    }
}
// @lc code=end
