/*
 * @lc app=leetcode id=202 lang=java
 * 1---1
 * 2---4   1+36=37  9+49 = 58 25+64=93 81+9 =90 81 64+1=65 36+25=61 
*  3---9   
 * [202] Happy Number
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        int[] square = {0,1,4,9,16,25,36,49,64,81};
        HashMap<Integer,Integer> map = new HashMap<>();
        
        while(n!=1){
            if(map.containsKey(n)) return false;
            int copy = n, number=0;
            while(copy!=0){
                number+=square[copy%10];
                copy/=10;
            }
            //System.out.print(number+" ");
            map.put(n,number);
            n=number;
        }
        return true;
    }
}
// @lc code=end

