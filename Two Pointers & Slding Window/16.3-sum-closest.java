/*
 * @lc app=leetcode id=16 lang=java
 * -4 -1 1 2 
 * [16] 3Sum Closest
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int delta = nums[0]+nums[1]+nums[2]-target;
        int base = 0;
        while(base<nums.length-2){
            int left=base+1, right=nums.length-1;
            while(left<right){
                int tempdelta = nums[base]+nums[left]+nums[right]-target;
                if(tempdelta==0) return target;
                if(Math.abs(delta)>Math.abs(tempdelta)){
                    delta = tempdelta;
                }
                if(tempdelta<0) left++;
                else right--;
            }
            base++;
        }
        return delta+target; 
    }
    
    public int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int delta = nums[0]+nums[1]+nums[2]-target;
        int base = 0;
        while(base<nums.length-2){
            int left = base+1, right = nums.length-1;
            while(left<right){
                int newdelta = nums[base]+nums[left]+nums[right]-target;
                if(newdelta==0) return target;
                if(Math.abs(newdelta)<Math.abs(delta)) { 
                    delta = newdelta;
                }//a new answer              
                if(newdelta<0) {
                    left=goRight(nums,left); 
                    left++;
                } else {
                    right = goLeft(nums,right); 
                    right--;
                }
            }
            base = goRight(nums,base); 
            base++;
        }
        return delta+target;
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

