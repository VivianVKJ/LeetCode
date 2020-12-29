package BackTracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum2 {
    static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int[] candidates = {1, 2, 2, 5};
        int target = 7;
        combinationSum2(candidates, target);
        for (List<Integer> list : ans)
            System.out.println(list.toString());
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, new ArrayList<>(), 0, target);
        return ans;
    }

    public static void backtrack(int[] can, List<Integer> curr, int index, int target) {
        if (target <= 0) {
            if (target == 0) ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = index; i < can.length; i++) {
            if (i > index && can[i] == can[i - 1]) continue;
            curr.add(can[i]);
            backtrack(can, curr, i + 1, target - can[i]);
            curr.remove(curr.size() - 1);
        }
    }
}
