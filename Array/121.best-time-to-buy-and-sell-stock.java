/*
 * @lc app=leetcode id=121 lang=java
 * change the pr
 * [121] Best Time to Buy and Sell Stock
 */
class Solution {

    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;       
        int max_diff = 0,flag =0;
        int min = prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]-min >= max_diff){
                max_diff = prices[i]-min;
                flag = 1;
            }
            if(prices[i]<min)
                min = prices[i];
        }
        if(flag == 0) return 0;
        return max_diff;
        
    }
}

