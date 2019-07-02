/*
 * @lc app=leetcode id=394 lang=cpp
 * Method 1： Stack for count and string
 * string temp saves the current str in []
 * [Notice] loop times may bigger than 10: 32[a2[c]]
 * [394] Decode String
 * 
*/
class Solution {
public:
    string decodeString(string s) {
        string temp_str = "";
        stack<int> repeat_times;
        stack<string> loop;
        int count = 0;
        for(int i = 0; i<s.size();i++){
            if(s[i]>='0' && s[i]<='9'){
                count = count*10 + s[i]-'0';
            }
            else if(s[i]=='['){
                repeat_times.push(count);
                loop.push(temp_str); //TIP: step in to a new [], save the str
                count = 0;
                temp_str.clear();
            }
            else if(s[i]==']'){
                int times = repeat_times.top();
                repeat_times.pop();
                while(times){
                    loop.top()+=temp_str;
                    times--;
                } //add times*loop to the lastest str
                temp_str = loop.top(); //!!update the newest 'open' str
                loop.pop();
            }
            else temp_str+=s[i];
        }
        if(loop.empty()) return temp_str;
        else return loop.top();
    }
};


