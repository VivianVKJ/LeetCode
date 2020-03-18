package DFS;

import java.util.ArrayList;
import java.util.List;

public class combination_sum {
    List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        combinationSum(candidates, target);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) return null;
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> currentList = new ArrayList<Integer>();
        DFS(candidates, target, results, currentList, 0, 0);
        return results;
    }

    public static void DFS(int[] candidates, int target, List<List<Integer>> results,
                           List currentList, int currentSum, int pos) {
        if (currentSum >= target) {
            if (currentSum == target) results.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            currentList.add(candidates[i]);
            DFS(candidates, target, results, currentList, currentSum + candidates[i], i);
            currentList.remove(currentList.size() - 1);
        }
    }
}
