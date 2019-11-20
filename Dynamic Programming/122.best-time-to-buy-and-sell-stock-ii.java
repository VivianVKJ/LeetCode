/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */
class Solution {
    public int maxProfit(int[] prices) {
            
        int n = prices.length;
        if(n<=1) return 0;       
        int[] gain = new int[n-1];
        for(int i=1;i<n;i++){
            gain[i-1] = prices[i]-prices[i-1];
        }
        int ans =0;
        for(int i=0;i<gain.length;i++){
            ans += gain[i]>0 ? gain[i]:0;
        }
        return ans;
        
    }
}

