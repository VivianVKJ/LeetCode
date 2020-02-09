/*
 * @lc app=leetcode id=344 lang=java
 *
 * [344] Reverse String
 */

// @lc code=start
class Solution {
    public void reverseString(char[] s) {
        helper(0,s);
    }
    public void helper(int index, char[] s){
        int n = s.length;
        if(index>=n/2 || n<=1)  return;
        char temp = s[index]; s[index] = s[n-index-1]; s[n-index-1]=temp;
        helper(index+1,s);
    }
}
// @lc code=end
