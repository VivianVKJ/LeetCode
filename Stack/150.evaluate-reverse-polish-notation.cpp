/*
 * @lc app=leetcode id=150 lang=cpp
 * cannot use { operator >= '0' }
 * stoi(string x) --> integer
 * [150] Evaluate Reverse Polish Notation
 */
class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<int> nums;
        for(int i=0;i<tokens.size();i++){
            if(tokens[i]=="+"||tokens[i]=="-"||tokens[i]=="*"||tokens[i]=="/")
            { //op
                int x = nums.top(); nums.pop();
                int y = nums.top(); nums.pop();
                 if(tokens[i]=="+") nums.push(x+y);
                 else if(tokens[i]=="-") nums.push(y-x);
                 else if(tokens[i]=="*") nums.push(x*y);
                 else if(tokens[i]=="/") nums.push(y/x);
            }
            else{ // number
                nums.push(stoi(tokens[i]));
            }
        }
        return nums.top();
    }
};

