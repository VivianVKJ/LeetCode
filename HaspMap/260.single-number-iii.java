/*
 * @lc app=leetcode id=260 lang=java
 *
 * [260] Single Number III
 */
class Solution {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();
        int[] ans = new int[2];
        for(int i=0;i<nums.length;i++){
            if(hash.contains(nums[i]))
                hash.remove(nums[i]);
            else hash.add(nums[i]);
        }
        Object[] t = hash.toArray();
        int i=0;
        while(i<2)
            ans[i]=(int)t[i++];
       return ans; 
    }
}

