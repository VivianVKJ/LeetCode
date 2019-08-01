/*
 * @lc app=leetcode id=3 lang=java
 * a b c b e f g
 * corner case: " "
 * [3] Longest Substring Without Repeating Characters
 */
class Solution {
    public int lengthOfLongestSubstring0(String s) {
        if(s.length()<=1) return s.length();
        int left = 0,right=0,result=0;
        int[] map = new int[256];
        for(left=0;left<s.length();left++){
            while(right<s.length() && map[s.charAt(right)]==0){
                map[s.charAt(right)]=1;
                result = Math.max(result,right-left+1);
                right++;
            }
            map[s.charAt(left)]=0;
        }
        return result;
    }

    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1) return s.length();
        int left = 0,right=0,result=0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(left=0;left<s.length();left++){
            while(right<s.length() && !map.containsKey(s.charAt(right))){
                map.put(s.charAt(right),right);
                result = Math.max(result,right-left+1);
                right++;
            }
            map.remove(s.charAt(left)); //remove until !map.containsKey
        }
        return result;
    }  

    public int lengthOfLongestSubstring_my(String s) {
        if(s.length()<=1) return s.length();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int left = 0,right=0,result=0;
        map.put(s.charAt(right++),0);
        while(right<s.length()){
            if(map.containsKey(s.charAt(right))){
                result = (right-left)>result ? right-left:result;
                while(left < map.get(s.charAt(right))){
                    map.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            map.put(s.charAt(right),right);
            right++;
        }
        result = (right-left)>result ? right-left:result;
        return result;
    }
}

