/*
 * @lc app=leetcode id=42 lang=cpp
 * https://www.cnblogs.com/grandyang/p/8887985.html
 * [42] Trapping Rain Water
 */
#include <stack>
class Solution {
public:
    int trap(vector<int>& height) {
        int i=0,temp,result=0;
        while(height[i]==0) i++;

        stack<int> water;
        int highest=height[i];
        cout<<"first h:"<<highest<<endl;
        water.push(height[i++]); //pushed the first elemnt
        
        for(i;i<height.size();i++){
            if(height[i]<highest) {
                water.push(height[i]);
                cout<<"push height["<<i<<"]:"<<height[i]<<endl;
            }
            else{ //height[i]>=highest;
                temp = highest * water.size();
                cout<<"temp="<<temp<<endl;
                while(!water.empty()){
                    temp-=water.top();
                    water.pop();
                    cout<<"pop height["<<i<<"]:"<<height[i]<<endl;
                }
                water.push(height[i]);
                cout<<"push height["<<i<<"]:"<<height[i]<<endl;
                highest=height[i];
                result+=temp;
                cout<<"result now ="<<result<<endl;
                temp=0;
            }
        }
        //Error: can't count the following segements of the actual hightest.
        return result;
    }
};

