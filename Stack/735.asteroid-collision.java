/*
 * @lc app=leetcode id=735 lang=java
 *
 * [735] Asteroid Collision
 */

// @lc code=start
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> stack = new Stack<>();
        //[5,-5]
        for(int i = 0; i < n; i++){
            stack.push(asteroids[i]);
            while (stack.size() > 1 && stack.peek() < 0) {
                int peek = stack.pop();
                if (stack.peek() < 0) {
                    stack.push(peek);
                    break;
                }
                if (stack.peek() < -peek) {
                    stack.pop();
                    stack.push(peek);
                } else if (stack.peek() == -peek)
                    stack.pop();
            }
        }
        int[] res = new int[stack.size()];
        n = stack.size() - 1;
        while (!stack.isEmpty())
            res[n--] = stack.pop();
        return res;
    }
}
// @lc code=end

