/*
 * @lc app=leetcode id=441 lang=java
 *
 * [441] Arranging Coins
 */

// @lc code=start

/* Note: 
* non-negative integer & 32-bit signed integer: 2^16-1
* would be easy to use long type first
* sum = (1+n)*n /2
* binary search: [l, r], find right margin, return r;
*/
class Solution {
    public int arrangeCoins(int n) {
        long l = 0, r = 65535;
        while (l <= r) {
            long mid = (l + r) / 2;
            long sum = mid * (mid + 1) / 2;
            // System.out.println(mid + ", " + sum);
            if (n == sum)
                return (int) mid;
            else if (n < sum || sum < 0)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return (int) r;
    }
}
// @lc code=end
