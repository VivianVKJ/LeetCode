/*
 * @lc app=leetcode id=739 lang=cpp
 * One pass by myself~
 * [739] Daily Temperatures
 */
class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& T) {
        vector<int> days(T.size(),0); //init 0;
        stack<int> cold_day; //save day index, compare temperature
        for(int i = 0; i<T.size();i++){
            if(cold_day.empty()) cold_day.push(i);
            else{ //not null
                while(T[i]>T[cold_day.top()]){
                    days[cold_day.top()] = i - cold_day.top();
                    cold_day.pop();
                    if(cold_day.empty()) break;
                }
                cold_day.push(i);
            }
        }
        return days;
    }
};

