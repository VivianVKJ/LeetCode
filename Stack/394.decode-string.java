/*
 * @lc app=leetcode id=394 lang=java
 * Note: Stack:
    * peek(): top without return
    * pop(): top and return 
 * [394] Decode String
 */

// @lc code=start
class Solution {
    public  String decodeString(String s) {
        int n = s.length();
        StringBuilder curr = new StringBuilder();
        Stack<Integer> number = new Stack<>();
        Stack<String> word = new Stack<>();

        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int num = c-'0';
                while(i<n && Character.isDigit(s.charAt(i+1))){
                    num *=10;
                    num +=s.charAt(i+1)-'0';
                    i++;
                }
                number.push(num);
            }
            else if(c=='['){ //renew curr, curr record the last []
                word.push(curr.toString()); //push curr [null,a]
                curr = new StringBuilder();
            }
            else if(c==']'){ //update curr
                StringBuilder tmp = new StringBuilder(word.pop()); //a
                int time = number.pop(); //
                while(time>0){
                    tmp.append(curr);
                    time--;
                }
                curr = tmp; //curr record the last []
            }
            else{ //letter
                curr.append(s.charAt(i));
            }
        }
        return curr.toString();
    }
}
// @lc code=end

