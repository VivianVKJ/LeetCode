/*
 * @lc app=leetcode id=18 lang=java
 * -2,-1,0,0,1,2
 * [18] 4Sum
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        int base = 0;
        while(base<nums.length-3){
            int inner_base = base+1;
            while(inner_base<nums.length-2){
                int left = inner_base+1, right = nums.length-1;
                while(left<right){
                    int temp_sum = nums[base]+nums[inner_base]+nums[left]+nums[right];
                    if(temp_sum==target){
                        results.add(Arrays.asList(nums[base],nums[inner_base],nums[left],nums[right]));
                        left = goRight(nums,left);
                        right = goLeft(nums,right);
                    }
                    else if(temp_sum<target)
                        left = goRight(nums,left);
                    else
                        right = goLeft(nums,right);
                }
                inner_base = goRight(nums,inner_base);
            }
            base =goRight(nums,base);
        }
        return results;
    }
    public int goRight(int[] nums, int left){
        while(left+1<nums.length && nums[left+1]==nums[left]) left++;
        return left+1;
    }    
    public int goLeft(int[] nums, int right){
        while(right-1>0 && nums[right-1]==nums[right]) right--;
        return right-1;
    }
}

