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
            if(s[i]>='0' && s[i]<='9'){
                count = count*10 + s[i]-'0';
            }
            else if(s[i]=='['){
                num.push(count);
                cout<<"meent '[', push count= "<< count
                    <<" loop"=loop<<endl;
                count = 0;
                str.push(loop);
                loop.clear();
            }
            else if(s[i]==']'){
                int times = num.top();
                num.pop();
                while(times-1){
                    str.top()+=loop;
                }
                cout<<"now top
                loop = str.top();
                str.pop();
            }
            else { loop+=s[i];}
            
        }

        return str.empty() ? loop : str.top();
    }
};


