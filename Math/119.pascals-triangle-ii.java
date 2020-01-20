/*
 * @lc app=leetcode id=119 lang=java
 *
 * [119] Pascal's Triangle II
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<=rowIndex;i++){
            if(i<2) ans.add(1);
            else{
                ans.add(1,i);
                for(int j=2;j<i;j++)
                    ans.set(j,ans.get(j)+ans.get(j+1));
            }
        }
        return ans;
    }
}
// @lc code=end

