/*
 * @lc app=leetcode id=20 lang=cpp
 *
 * [20] Valid Parentheses
 */
#include <stack>
class Solution {
public:
    bool isValid(string s) {
        stack<char> brackets;
        for(int i=0; i<s.size();i++){
            char c=s[i];
            if(c=='('||c=='{'||c=='[') brackets.push(c);
            else {
                if(brackets.empty()) return false;
                if(c==')' && brackets.top()=='(') brackets.pop();
                else if(c==']' && brackets.top()=='[')  brackets.pop();
                else if(c=='}' && brackets.top()=='{')  brackets.pop();
                else return false;
            }
        }
        return brackets.empty();
    }
};

