/* Bucket Sorting
 * @lc app=leetcode id=41 lang=java
 * [1]
 * [41] First Missing Positive
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int[] record  = new int[n];
        int i = 0;
        for( i = 0;i<n;i++){
            if(nums[i]>=1 && nums[i]<=n)
                record[nums[i]-1]=1;
        }

        for( i=0;i<record.length;i++){
            if(record[i]==0)
                return i+1;   
        }
        return i+1;
    }
}

