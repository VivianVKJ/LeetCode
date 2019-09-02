/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */
class Solution {
    public void sortColors(int[] nums) {
        int[] ans = new int[3];
        for(int i=0;i<nums.length;i++){
            ans[nums[i]]++;
        }
        // System.out.printf("%d,%d,%d",ans[0],ans[1],ans[2]);
        int i = 0;
        for(int color=0;color<3;color++){
            while(ans[color]>0){
                nums[i]=color;
                ans[color]--;
                if(i+1<nums.length) i++;
            }
        }

    }
}

