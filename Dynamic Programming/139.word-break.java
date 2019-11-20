/*
 * @lc app=leetcode id=139 lang=java
 * "catsandog"\n["cats","dog","sand","and","cat"]
 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
 * [139] Word Break
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s,List<String>wordDict){
        Boolean[] cache = new Boolean[s.length()+1]; //default null
        cache[0] = true;
        HashSet<String> set = new HashSet<String>();
        for(String curr:wordDict)
            set.add(curr);
        return helper(s,cache,set);
    }
    public static boolean helper(String s, Boolean[] cache,HashSet<String> set){
        if(cache[s.length()]!=null) return cache[s.length()+1];
        if(set.contains(s)) {
            cache[s.length()]=true;
            return cache[s.length()];
        }
        for(int i = 1;i<s.length();i++){
            if(helper(s.substring(0,i),cache,set) && set.contains(s.substring(i))){
                cache[s.length()] = true;
                return true;
            }
        }
        cache[s.length()] = false;  //!Error 1
        return false;
    }


    public boolean wordBreak_DP(String s, List<String>wordDict){
        boolean[] dp = new boolean[s.length()+1];
        HashSet dict = new HashSet<String>();
        dp[0]=true;
        for(int i = 0; i<wordDict.size(); i++){
            dict.add(wordDict.get(i));
        }
        for(int i=1;i<s.length()+1;i++){
            for(int j=i;j>=0;j--){ //substring: [i-j,j)
                String curr = s.substring(i-j,i);
                if(dict.contains(curr) && dp[i-j]==true){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    
    public boolean wordBreak_OtherDFS(String s, List<String> wordDict) {
        return DFS(s,new StringBuilder(),wordDict.toArray(new String[0]));
    }
    public boolean DFS(String s, StringBuilder curr, String[] dict){
        if(curr.length()>s.length()) return false;
        if(!s.startsWith(curr.toString())) return false;
        if(curr.length() == s.length()) return true;
        
        for(String word:dict){
            if(DFS(s,curr.append(word),dict))
                return true;
            curr.delete(curr.length()-word.length(),curr.length());
        }
        return false;
    }

    public static boolean wordBreak_MyDFS(String s, List<String> wordDict) {
        HashMap<Character,List<String>> dict = new HashMap<Character,List<String>>();
        for(int i = 0; i<wordDict.size(); i++){
            String curr = wordDict.get(i);
            char first = curr.charAt(0);
            if(dict.containsKey(first)){
                dict.get(first).add(curr);
            }
            else{
                List<String> newString = new ArrayList<String>();
                newString.add(curr);
                dict.put(first,newString);
            }
        }
        return search(dict,s,0);
    }
    public static boolean search(HashMap<Character,List<String>> dict,String s, int index){
        boolean res = false;
        if(index == s.length()) return true;
        if(dict.containsKey(s.charAt(index))) {
            int choices = dict.get(s.charAt(index)).size(); //dict start with
            for (int i = 0; i < choices; i++) {
                if (nextword(s, index, dict.get(s.charAt(index)).get(i)) == true) {
                    res =  search(dict, s, index + dict.get(s.charAt(index)).get(i).length());
                    if (res) break;
                }
            }
        }
        return res;
    }


    public static boolean nextword(String s, int start, String target){
        if(s.length()-start < target.length()) return false;
        for(int i=0;i<target.length();i++)
            if(s.charAt(start+i)!=target.charAt(i)) return false;
        return true;
    }
}

// @lc code=end

