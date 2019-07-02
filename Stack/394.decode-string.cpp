/*
 * @lc app=leetcode id=394 lang=cpp
 * Method 1： Stack
 * [Notice] loop times may bigger than 10 32[a2[c]]
 * [394] Decode String
 * Time Limit Exceeded O(n²)
 * 
*/
class Solution {
public:
    string decodeString(string s) {
        stack<string> str; //use string stack
        stack<int> num;
        int count=0;
        string loop = "";

        for(int i=0; i<s.size();i++){
            if(s[i]>='0' && s[i]){
                count = count*10 + s[i]-'0';
            }
            else if(s[i]=='['){
                count = 0;
                codes.push(s[i]);
                cout<<"push "<<codes.top()<<"  ";
            }
            else if(s[i]==']'){
                int times = num.top();
                num.pop();
                while(times-1){
                    

                }
                str.push(loop);
                
                loop="";
            }
            else { loop+=s[i];}
            
        }
        stack<char> rresult;
        while(!codes.empty()){
            rresult.push(codes.top());
            codes.pop();
        }
        while(!rresult.empty()){
            result += rresult.top();
            rresult.pop();
        }
        return result;
    }
};


