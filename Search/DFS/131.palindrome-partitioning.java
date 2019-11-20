/*
 * @lc app=leetcode id=131 lang=java
 * think about the split position
 * [131] Palindrome Partitioning
 */
class Solution {
    public List<List<String>> partition(String s) {
        if(s.isEmpty()) return null;
        List<List<String>> results = new ArrayList<List<String>>();
        List<String> currentAns = new ArrayList<String>();
        DFS(s, results,currentAns,0);
        return results;
    }
    public void DFS(String s, List<List<String>> results, 
                    List<String> currentAns, int startPos ){
        if(startPos==s.length()){
            results.add(new ArrayList<String>(currentAns));
            return;
        }
        for(int i = startPos;i<s.length();i++){
            String sub = s.substring(startPos,i+1);  //string stl
            if(isValid(sub)){
                currentAns.add(sub);
                DFS(s,results,currentAns,i+1);
                currentAns.remove(currentAns.size()-1);
            }
        }
    }
    public boolean isValid(String sub){
        for(int i=0,j=sub.length()-1;i<j;i++,j--){
            //if(sub[i]!=sub[j]) return false;
            if(sub.charAt(i)!=sub.charAt(j)) return false;
        }
        return true;
    }
}

