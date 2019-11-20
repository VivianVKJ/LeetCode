/*
1247. Minimum Swaps to Make Strings Equal
*/
//https://leetcode.com/contest/weekly-contest-161/problems/minimum-swaps-to-make-strings-equal/

class Solution {
    public int minimumSwap(String s1, String s2) {
        int cx_y = 0, cy_x = 0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                if(s1.charAt(i)=='x') cx_y+=1;
                else cy_x+=1;
            }
        }
        if((cx_y+cy_x)%2!=0) return -1;
        //need to get paired
        
        // xx, yy needs one swap, and xy yx needs two swaps, so find the pair of x and the number of redundant x
        return cx_y/2 + cy_x/2 + (cx_y%2)*2;
    }
}