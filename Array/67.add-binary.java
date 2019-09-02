/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 */
class Solution {
    public String addBinary(String a, String b) {
        int la = a.length()-1, lb=b.length()-1;
        int add = 0;
        int len = Math.max(la,lb)+2;
        int[] ans = new int[len];
        len-=1;
        StringBuilder sb = new StringBuilder();
        while(la>=0 || lb>=0 || add>0){
            if(la>=0) add += a.charAt(la--)-'0';
            if(lb>=0) add += b.charAt(lb--)-'0';
            ans[len--] = add%2;
            add /=2;
        }
        int i = (ans[0]==0) ? 1 : 0;
        for(;i<ans.length;i++){
            sb.append(ans[i]);
        }
        // System.out.print(sb.toString());
        return sb.toString();
    }
}

