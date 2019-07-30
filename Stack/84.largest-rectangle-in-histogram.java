/*
 * @lc app=leetcode id=84 lang=java
 * --------------------------------------------------
 * [find the first smaller number on the left: STACK]
 * --------------------------------------------------
 * remain an increasing sequence in the stack
 * if [current]<stack.peek: peek has a right edge
 * [84] Largest Rectangle in Histogram
 * Edge Case: [1]
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights==null) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int largest = 0;
        for( int current = 0; current<=heights.length; current++){
            if(stack.isEmpty()) {
                stack.push(current);
            }
            else if(current<heights.length &&  heights[current] > heights[stack.peek()]) {
                stack.push(current);
            } 
            else{
                int high = heights[stack.peek()]; //height of rectangule
                stack.pop();
                int left_edge = stack.isEmpty() ? -1 : stack.peek();
                int temp = (current-left_edge-1) * high;
                largest = (temp>largest) ? temp : largest;   
                current-=1;     
            }
        }
        return largest;
    }//14ms
  /*  
    public int largestRectangleAreaError(int[] heights) {
        if(heights==null) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int largest = 0;
        for( int current = 0; current<heights.length; current++){
            if(stack.isEmpty()|| heights[current] > heights[stack.peek()])
                stack.push(current);
            else{
                int high = heights[stack.peek()]; //height of rectangule
                stack.pop();
                int width = stack.isEmpty() ? current : (current-stack.peek()-1);
                int temp = width* high;
                largest = (temp>largest) ? temp : largest;   
                current-=1;     
            }
        }
        return largest;
    }
    */
}


