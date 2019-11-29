/*
 * @lc app=leetcode id=1013 lang=java
 *
 * [1013] Partition Array Into Three Parts With Equal Sum
 */

// @lc code=start
class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int n = A.length;
        if(n<=2) return false;
        int total = 0;
        for(int i=0;i<n;i++)
            total+=A[i];
        if(total%3!=0) return false;
        total/=3;
        
        int sum = 0, count = 0;
        for(int i=0;i<n;i++){
            sum+=A[i];
            if(sum ==total) {
                sum = 0;
                count++;
            }
        }
    
        if(count>=3) return true;
        return false;
    }
}
// @lc code=end

