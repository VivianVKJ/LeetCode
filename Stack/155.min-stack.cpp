/*
 * @lc app=leetcode id=155 lang=cpp
 *  
 * [155] Min Stack
 */
class MinStack {
public:
    /** initialize your data structure here. */
    MinStack() {}
    void push(int x) {
        nums.push(x);
        if(mins.empty()||x<=getMin() ) mins.push(x);
    }  
    void pop() {
        if(mins.top()==nums.top()) mins.pop();
        nums.pop();
    } 
    int top() {
        return nums.top();
    }   
    int getMin() {
        return mins.top();
    }
    
private:
    stack<int> nums, mins;
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */

