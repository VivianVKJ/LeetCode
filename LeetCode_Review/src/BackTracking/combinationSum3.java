package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class combinationSum3 {
    static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7).size());
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        backTrack(k, n, 1, 0, new ArrayList<>());
        return ans;
    }

    public static void backTrack(int k, int n, int index, int sum, List<Integer> curr) {
        if (curr.size() == k) {
            if (sum == n) ans.add(new ArrayList<>(curr));
            return;
        }
        if (sum > n) return;

        for (int i = index; i < 10; i++) {
            curr.add(i);
            backTrack(k, n, i + 1, sum + i, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
