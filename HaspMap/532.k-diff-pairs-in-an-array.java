/*
 * @lc app=leetcode id=532 lang=java
 *
 * [532] K-diff Pairs in an Array
 */

// @lc code=start
class Solution {
    public int findPairs(int[] nums, int k) {
        int n = nums.length;
        if(n<=1 || k <0) return 0;
    
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums)
            map.put(i,map.getOrDefault(i,0)+1);
        // for(int key : map.keySet())
        //     ...
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(k==0){
                if(entry.getValue()>=2)
                    res++;
            }
            else{
                if(map.containsKey(entry.getKey()+k))
                    res++;
            }
        }
        return res;
    }
}
// @lc code=end

