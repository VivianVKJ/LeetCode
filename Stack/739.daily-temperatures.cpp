/*
 * @lc app=leetcode id=739 lang=cpp
 *
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
                    //cout<<"i="<<i<<"  ";
                    days[cold_day.top()] = i - cold_day.top();
                    //cout<<"stack top"<<cold_day.top()<<"  ";
                    //cout<<"day="<<days[cold_day.top()]<<" and pop!"<<endl;
                    cold_day.pop();
                    if(cold_day.empty()) break;
                }
                cold_day.push(i);
                //cout<<"push day:"<<i<<endl;
            }
        }
        return days;
    }
};

