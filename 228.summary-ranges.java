/*
 * @lc app=leetcode id=228 lang=java
 *
 * [228] Summary Ranges
 */

// @lc code=start
class Solution {
    //[0,2,3,4,6,8,9]
    //Output: ["0","2->4","6","8->9"]
    List<String> ans = new ArrayList<>();
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        if(n == 0) return ans;
        int l = 0, r = 0;
        while(r < n){
            while(r+1 < n && nums[r+1] == nums[r]+1)
                r += 1;
            insertSum(nums[l], nums[r]);
            r += 1;
            l = r;
        }
       return ans;
    }
    public void insertSum(int l, int r){
        String s = "";
        s += l;
        if(r != l)
            s += ("->" + r);
        ans.add(s);
    }
}
// @lc code=end

