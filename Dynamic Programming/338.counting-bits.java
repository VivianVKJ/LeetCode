/*
 * @lc app=leetcode id=338 lang=java
 *
 * [338] Counting Bits
 */
class Solution {
    public int[] countBits(int num) {
        int[] count = new int[num + 1];
        for (int i = 1; i <= num; i++)
            count[i] = count[i >> 1] + (i & 1);
        return count;
    }

    public int[] countBits_divide(int num) {
        int[] ans = new int[num + 1];
        ans[0] = 0;
        if (num == 0)
            return ans;
        ans[1] = 1;
        if (num == 1)
            return ans;
        // for(int i=2;i<num+1;i++){
        // ans[i] = (i%2==0) ? ans[i/2] : ans[i/2]+1;
        // }
        for (int i = 2; i < num + 1; i++)
            ans[i] = ans[i / 2] + i % 2;
        return ans;
    }
}
