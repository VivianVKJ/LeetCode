/*
 * @lc app=leetcode id=232 lang=java
 * Tip: if reserve!=empty, go ahead peek and pop reserve stack
 * [232] Implement Queue using Stacks
 */
class MyQueue {
    Stack<Integer> nums = new Stack<Integer>(); 
    Stack<Integer> reserver = new Stack<Integer>(); 
    /** Initialize your data structure here. */
    public MyQueue() {}
    /** Push element x to the back of queue. */
    public void push(int x) {
        nums.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //nums=[1,2,3,4]; reserver = [4,3,2,1]
        //Error 2: check if reserve.empty()
        if(reserver.empty()){
            while(!nums.empty()){
                reserver.push(nums.peek());
                nums.pop();
            }
        }
        int x = reserver.peek();
        reserver.pop();
        return x;
    }
    
    /** Get the front elemen. */
    public int peek() {
        if(reserver.empty()){
            while(!nums.empty()){
                reserver.push(nums.peek());
                nums.pop();
            }
        }
        return reserver.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return nums.empty() && reserve.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

