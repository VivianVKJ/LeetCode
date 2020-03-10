/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] ZigZag Conversion
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if(s.length()<=numRows || numRows==1) return s;
        
        List<StringBuilder> rows = new ArrayList<>();
        int group_size = numRows*2-2;
        for(int i=0;i<numRows;i++)  rows.add(new StringBuilder());
        
        for(int i=0;i<=s.length()/group_size;i++){
            for(int j=0;j<group_size;j++){
                if(i*group_size+j<s.length()){
                    char letter = s.charAt(i*group_size+j);
                    if(j<numRows) rows.get(j).append(letter);
                    else rows.get(numRows-1-j%(numRows-1)).append(letter);
                }     
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<numRows;i++) ans.append(rows.get(i));
        return ans.toString();   
    }
}
// @lc code=end

