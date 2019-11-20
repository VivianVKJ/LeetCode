/*
 * @lc app=leetcode id=29 lang=java
 * -2147483648\n-1
 * [29] Divide Two Integers
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==0) return 0;
        if(divisor==0) return Integer.MAX_VALUE;
        int sign = -1;
        if(dividend>0 && divisor>0) sign =1;
        if(dividend<0 && divisor<0) sign =1;
        if(dividend==Integer.MIN_VALUE && divisor==-1)
            return Integer.MAX_VALUE;
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        
        int res = 0;
        int shift = 0;
        while(a>=b){
            shift=0;
            while(a>=b<<shift){
                shift+=1;
            }
            a-=b<<(shift-1);
            res+=1<<(shift-1);
        }
        return sign==1 ? res: -res;
    }

}
// @lc code=end

