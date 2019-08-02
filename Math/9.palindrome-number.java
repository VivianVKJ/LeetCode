/*
 * @lc app=leetcode id=9 lang=java
 * int i ∈ -2147483648~2147483647）
 * new int[10] is enough
 * [9] Palindrome Number
 */
class Solution {
    public boolean isPalindrome(int x){
        if(x<0) return false;
        if(x<10) return true;
        int copyx=x,reverse=0;
        while(copyx!=0){
            reverse = reverse*10+copyx%10;
            copyx/=10;
        }
        return (reverse==x);
    }
    public boolean isPalindrome_slower(int x) {
        if(x<0) return false;
        if(x<10) return true;
        int len = 0;
        int copyx = x;
        int[] num = new int[10];
        while(copyx/10!=0) {
            num[len]=copyx%10;
            len++;
            copyx/=10;
        } 
        num[len]=copyx;
        copyx=x;
        for(int i = len;i>len/2;i--){
            System.out.print(num[i]);
            if(num[i]!=copyx%10) return false;
            copyx/=10;
        }    
        return true;
    }
    public boolean isPalindrome_slow(int x) {
        if(x<0) return false;
        if(x<10) return true;
        int len = 0;
        int copyx = x;
        while(copyx/10!=0) {
            len++;
            copyx/=10;
        }
        copyx=x;
        int loop = len/2;
        while(len>0){
            if(len<loop) return true;
            if(copyx/(int)(Math.pow(10,len))!=x%10)
                return false;
            copyx%=(int)(Math.pow(10,len));
            x/=10;
            len--;
        }
        return true;
    }
}

