/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */
class Solution {
    String keyboard[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> results =new ArrayList<String>();
        if(digits.length()==0) return results;
        String current = "";
        helper(digits,results,current);
        return results;
    }
    public void helper(String digits,List<String> results,String current){
        int len = digits.length();
        if(current.length()==len) {
            results.add(current);
            return;
        }
        if(current.length()<len){
            int key = digits.charAt(current.length())-'0';
            for(int i=0;i<keyboard[key].length();i++){
                helper(digits,results,current+keyboard[key].substring(i,i+1));
            }
        }
    }
}

