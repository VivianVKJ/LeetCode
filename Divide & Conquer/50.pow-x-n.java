/*
 * @lc app=leetcode id=50 lang=java
 * 0.00001\n2147483647
 * 2.00000\n-2147483648  expected 0.0
 * -1.00000\n-2147483648
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        if(n<0) {
            x = 1.0/x;
            if(n==Integer.MIN_VALUE)
                return 1.0/x * myPow(x,-(n+1));
            else n=-n;
        }
        if(n==0) return 1;
        double ans = 1;
        return n%2==1 ? x * myPow(x*x,n/2) : myPow(x*x,n/2);
    }
}
// @lc code=end

