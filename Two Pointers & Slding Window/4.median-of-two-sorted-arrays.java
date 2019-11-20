/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2=nums2.length;
        int half = (len1+len2)/2, odd = (len1+len2)%2;
        int[] nums3 = new int[half+1];
        int p1=0,p2=0;
        for(int i=0;i<half+1;i++){
            if(p1<len1 && p2<len2){
                nums3[i] = nums1[p1]<nums2[p2] ? nums1[p1] : nums2[p2];
                if(nums1[p1]<nums2[p2]) p1++;
                else p2++;
            }
            else {
                nums3[i] = p1<len1 ? nums1[p1] : nums2[p2];
                if(p1<len1) p1++;
                else p2++;
            }
        }
        // for(int i=0;i<half+1;i++) System.out.print(nums3[i]);
        if(odd==1) return nums3[half]/1.0;
        return (nums3[half-1]+nums3[half])/2.0;
    }
}

