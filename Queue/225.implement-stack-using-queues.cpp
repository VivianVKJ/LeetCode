/*
 * @lc app=leetcode id=225 lang=cpp
 * save numbers in stack's way
 * think about how to push 
 * [225] Implement Stack using Queues
 */
class MyStack {
public:
    /** Initialize your data structure here. */
    queue<int> temp;   //temp queue
    queue<int> reserve; //final queue
    MyStack() {  }
    
    /** Push element x onto stack. */
    void push(int x) {
        while(!reserve.empty()){
            temp.push(reserve.front());
            reserve.pop();
        }
        reserve.push(x);
        while(!temp.empty()){
            reserve.push(temp.front());
            temp.pop();
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    int pop() {
        int x = reserve.front();
        reserve.pop();
        return x;
    }
    
    /** Get the top element. */
    int top() {
        return reserve.front();
    }
    
    /** Returns whether the stack is empty. */
    bool empty() {
        return reserve.empty();
    }
};

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack* obj = new MyStack();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->top();
 * bool param_4 = obj->empty();
 */

