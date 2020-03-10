import java.util.*;

/*
 * @lc app=leetcode id=805 lang=java
 * sum of subsets
 * [805] Split Array With Same Average
 */

// @lc code=start
class Solution {
    public boolean splitArraySameAverage(int[] A) {
        int sum = 0;
        for (int i : A)
            sum += i;
        if (!isPossible(sum, A.length))
            return false;

        List<Set<Integer>> ls = new ArrayList<>();
        for (int i = 0; i <= A.length / 2; i++) {
            ls.add(new HashSet<>());
        }
        ls.get(0).add(0);

        for (int num : A) {
            for (int i = ls.size() - 1; i > 0; i--) {
                if (ls.get(i - 1).size() > 0) {
                    for (int s : ls.get(i - 1))
                        ls.get(i).add(s + num);
                }
            }
        }

        for (int i = 1; i < ls.size(); i++) {
            if (sum * i % A.length == 0 && ls.get(i).contains(sum * i / A.length))
                return true;
        }
        return false;
    }

    private boolean isPossible(int sum, int n) {
        for (int i = 1; i < n; i++) {
            if (sum * i % n == 0)
                return true;
        }
        return false;
    }
}
// @lc code=end
