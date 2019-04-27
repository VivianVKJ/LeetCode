/*
 * @lc app=leetcode id=134 lang=cpp
 * Tag: Greedy
 * [134] Gas Station
 * if the car starts at A and cannot reach B,  any station between A & B cannot reach B
 */
class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int result = 0, tempGas = 0, totalEarn = 0, start = 0;
        for (int i = 0; i < gas.size(); i++){

            totalEarn += gas[i] - cost[i];
            tempGas += gas[i] - cost[i];
            if (tempGas < 0){
                start = i + 1;
                tempGas = 0;
            }
        }
        if (totalEarn < 0 || start == gas.size())
            result = -1;
        else
            result = start;
        return result;
    }
};

