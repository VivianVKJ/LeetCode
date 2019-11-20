/*
 * @lc app=leetcode id=76 lang=java
 *  "a"\n"b"
 *  "aa"\n"aa"
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        int l=0,r=0,min=s.length(),exist = 0;
        int ans_l=0,ans_r=0,count =0; // count_goal = t.length();
        HashMap<Character,Integer> dict = new HashMap<Character,Integer>(); //dict
        HashMap<Character,Integer> curr = new HashMap<Character,Integer>(); //dict
        for(int i=0;i<t.length();i++){
            Character c = t.charAt(i);
            dict.put(c,dict.getOrDefault(c,0)+1);
            curr.putIfAbsent(c,0);
        }
        for(r=0;r<s.length();r++) {
            char temp_r = s.charAt(r);
            if (dict.containsKey(temp_r)) {
                l = r;
                break;
            }
        }  //ERROR: "ab"\n"a"
        for(r=0;r<s.length();r++){
            char temp_r = s.charAt(r);
            if(dict.containsKey(temp_r)){ //right meet new character
                curr.put(temp_r,curr.get(temp_r)+1);
                if(curr.get(temp_r)<=dict.get(temp_r) ) count++;
                while(count==t.length()){ //left side move
                    exist = 1;
                    if((r-l+1)<=min){
                        min = r-l+1;
                        ans_l = l;
                        ans_r = r;
                    }
                    curr.put(s.charAt(l),curr.get(s.charAt(l))-1);
                    if(curr.get(s.charAt(l))<dict.get(s.charAt(l))) count-=1;

                    l+=1;
                    while(l<=r && dict.containsKey(s.charAt(l))!=true)
                        l++;
                }
            }
        }
        if(exist==0) return ""; //ERROR: "ab"\n""
        return s.substring(ans_l,ans_r+1);
    }
}
// @lc code=end

