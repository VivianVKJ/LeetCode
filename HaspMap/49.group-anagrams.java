/*
 * @lc app=leetcode id=49 lang=java
 * *1*0*0*0*1*0*0*0*0*0*0*0*0*0*0*0*0*0*0*1*0*0*0*0*0*0 
 * *1*0*0*0*1*0*0*0*0*0*0*0*0*0*0*0*0*0*0*1*0*0*0*0*0*0 
 * [49] Group Anagrams
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> ans = new ArrayList<>();
        if(n==0) return ans;
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            
            String key = encode(s);
            List<String> value = map.getOrDefault(key, new ArrayList<String>());
            value.add(s);
            map.put(key,value);
        }
        for(String s : map.keySet()){
            ans.add(map.get(s));
        }
        return ans;
    }
    public String encode(String s){
        int[] alphabet = new int[26];
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            alphabet[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<26;i++){
            sb.append("*");
            sb.append(alphabet[i]);
        }
        // System.out.print(sb.toString()+" ");
        return sb.toString();
     }
}
// @lc code=end

