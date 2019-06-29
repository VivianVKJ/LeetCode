/*
 * @lc app=leetcode id=232 lang=cpp
 * use extra stack
 * runtime 100%
 * usage 32.3%
 * [232] Implement Queue using Stacks
 */
class MyQueue {
public:
    /** Initialize your data structure here. */
    stack<int> nums;
    MyQueue() { }
    
    /** Push element x to the back of queue. */
    void push(int x) {
        stack<int> temp;
        while(!nums.empty()){
            temp.push(nums.top());
            nums.pop();
        }
        nums.push(x);
        while(!temp.empty()){
            nums.push(temp.top());
            temp.pop();
        }
    }
    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        //Error 1: 'int' pop
        int x = nums.top();
        nums.pop();
        return x;
    }
    
    /** Get the front element. */
    int peek() {
        return nums.top();
    }
    
    /** Returns whether the queue is empty. */
    bool empty() {
        return nums.empty();
    }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */

