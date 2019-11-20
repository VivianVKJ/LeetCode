/*
 * @lc app=leetcode id=476 lang=java
 *
 * [476] Number Complement
 */
class Solution {
    public int findComplement(int num){
        int highestbit = Integer.highestOneBit(num);
        int mask = (highestbit<<1)-1;
        // System.out.printf("%d,%d ",highestbit,mask);
        num = ~num;
        // System.out.printf("%d,%d ",num,num&mask);
        return num&mask;

        
    }
    public int findComplement_simple(int num) {
        int[] ans = new int[32];
        int mask =1,i=0;
        while(num!=0){
            ans[i++] = num%2;
            num/=2;
        }
        int res = 0;
        for(int j=i-1;j>=0;j--){
            res = res*2 + (ans[j]==0 ? 1 : 0);
        }
        return res;     
    }
}

