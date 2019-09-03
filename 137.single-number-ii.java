/*
 * @lc app=leetcode id=137 lang=java
 * 三进制下的异或运算 不进位加法
 * [137] Single Number II
 */
class Solution {
    public int singleNumber(int[] nums) {
        int res =0;
        int[] count = new int[32];
        for(int i=0;i<32;i++){
            for(int j = 0;j<nums.length;j++){
                count[i]+= ( (nums[j]>>i) & 1);
                count[i]%=3;
            }
            if(count[i]!=0) 
                res = res | count[i]<<i;
        }
        return res;
    }
}

