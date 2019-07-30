/*
 * @lc app=leetcode id=15 lang=java
 * -4 -1 -1 0 1 2
 * [15] 3Sum
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        int base = 0;
        int len = nums.length;
        while(base<len-2){
            int target = 0 - nums[base];
            int left = base+1, right = len-1;
            while(left<right){
                if(nums[left]+nums[right]==target){
                    results.add(Arrays.asList(nums[base],nums[left],nums[right]));
                    left = goRight(nums,left); left++;          
                    right = goLeft(nums,right); right--;
                }
                else if(nums[left]+nums[right]<target){
                    left = goRight(nums,left); left++;
                }
                else{
                    right = goLeft(nums,right); right--;
                }
            }
            base = goRight(nums,base);  base++; //avoid duplicate
        }
        return results;
    }
    public int goRight(int[] nums, int left){
        while(left+1<nums.length && nums[left+1]==nums[left]) left++;
        return left;
    }    
    public int goLeft(int[] nums, int right){
        while(right-1>0 && nums[right-1]==nums[right]) right--;
        return right;
    }
}

