/*
 * @lc app=leetcode id=7 lang=java
 * Integer.MAX_VALUE = 2147483647
 * Integer.MIN_VALUE = -2147483648
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int last=0, rev=0;
        while(x!=0){
            if(rev > Integer.MAX_VALUE/10 || rev<Integer.MIN_VALUE/10) return 0;
            rev = rev*10+x%10;
            x/=10;
        }
        if(rev>Integer.MAX_VALUE || rev<Integer.MIN_VALUE) return 0;
        return rev;
    }
}
// @lc code=end

