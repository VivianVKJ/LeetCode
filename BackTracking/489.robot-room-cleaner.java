/*
 * @lc app=leetcode id=489 lang=java
 *
 * [489] Robot Room Cleaner
 */

// @lc code=start
/**
 * // This is the robot's control interface. // You should not implement it, or
 * speculate about its implementation interface Robot { // Returns true if the
 * cell in front is open and robot moves into the cell. // Returns false if the
 * cell in front is blocked and robot stays in the current cell. public boolean
 * move();
 *
 * // Robot will stay in the same cell after calling turnLeft/turnRight. // Each
 * turn will be 90 degrees. public void turnLeft(); public void turnRight();
 *
 * // Clean the current cell. public void clean(); }
 */

class Solution {
    int[] dir = { -1, 0, 1, 0, -1 };

    public void cleanRoom(Robot robot) {
        dfs(robot, new HashSet<>(), 0, 0, 0);
    }

    public void dfs(Robot robot, HashSet<String> visited, int x, int y, int d) {
        String key = x + "," + y;
        if (visited.contains(key))
            return;
        visited.add(key);
        robot.clean();
        for (int i = 0; i < 4; i++) {
            if (robot.move()) {
                dfs(robot, visited, x + dir[d], y + dir[d + 1], d);
                backward(robot);
            }
            robot.turnRight();
            d = (d + 1) % 4;
        }
    }

    public void backward(Robot robot) {
        robot.turnLeft();
        robot.turnLeft();
        robot.move();
        robot.turnLeft();
        robot.turnLeft();
    }
}
// @lc code=end
