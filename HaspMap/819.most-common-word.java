/*
 * @lc app=leetcode id=819 lang=java
 * "a, a, a, a, b,b,b,c, c"\n["a"]
 * [819] Most Common Word
 */

// @lc code=start
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        String[] split = paragraph.toLowerCase().split("\\W+");
        HashMap<String,Integer> map = new HashMap<>();
       
        for(String word : split){
            word = word.replaceAll("[^a-z^A-Z]","");
            map.put(word,map.getOrDefault(word,0)+1);
        }
        for(String ban : banned){
            if(map.containsKey(ban))
                map.remove(ban);
        }
        int times = -1;
        String ans = "";
        for(String key : map.keySet()){
            if(map.get(key)>times){
                times = map.get(key);
                ans = key;
            }
        }
        return ans;
    }
}
// @lc code=end

