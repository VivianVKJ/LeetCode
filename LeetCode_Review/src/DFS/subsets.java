package DFS;

import java.util.ArrayList;
import java.util.List;

public class subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        DFS(nums, 0, curr, ans);
        return ans;
    }

    public static void DFS(int[] nums, int index, List<Integer> curr, List<List<Integer>> ans) {
        if (index > nums.length) return;
        ans.add(new ArrayList<Integer>(curr));

        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            DFS(nums, i + 1, curr, ans);
            curr.remove(curr.size() - 1);
        }
    }
}
