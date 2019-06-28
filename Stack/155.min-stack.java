/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> nums = new Stack<Integer>();
    Stack<Integer> mins = new Stack<Integer>();
    public MinStack() {
        
    }
    public void push(int x) {
        nums.push(x);
        if(mins.empty()||x<=getMin() ) mins.push(x);
    }  
    public void pop() {
        // Cannot write like the following:
        // if (mins.peek() == nums.peek()) s2.pop();
        int x = nums.peek();
        int y= getMin();
        if(y==x) mins.pop();
        nums.pop();
    } 
    public int top() {
        return nums.peek();
    }   
    public int getMin() {
        return mins.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

