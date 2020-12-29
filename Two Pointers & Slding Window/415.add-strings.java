/*
 * @lc app=leetcode id=415 lang=java
 * ""9"\n"1""
 * [415] Add Strings
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        int l1 = num1.length(), l2 = num2.length();
        int inc = 0, dig = 0, len = Math.max(l1, l2);
        String ans = "";
        for (int i = 0;  i < len; i++) {
            dig = 0;
            if (i < l1 && i < l2)
                dig = inc + num1.charAt(l1-i - 1) - '0' + num2.charAt(l2-i-1) - '0';
            else
                dig = i < l1 ? inc + num1.charAt(l1-i-1) - '0' : inc + num2.charAt(l2-i-1) - '0';
            inc = dig / 10;
            dig = dig % 10;
            ans = dig + ans;
        }
        return inc > 0 ? inc + ans : ans;
    }
}
// @lc code=end

