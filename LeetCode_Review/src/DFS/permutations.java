package DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//46. Permutations
public class permutations {
    public List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        permutations p = new permutations();
        int[] nums = {1, 2, 3};
        p.permutation(nums);
        System.out.println(p.ans.toString());

    }

    // used array is faster than hashset
    public List<List<Integer>> permutation(int[] nums) {
        this.backtrack(nums, new boolean[nums.length], new ArrayList<>());
        //this.dfs(nums, new HashSet<Integer>(), new ArrayList<>());
        return this.ans;
    }

    public void backtrack(int[] nums, boolean[] used, List<Integer> curr) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == false) {
                used[i] = true;
                curr.add(nums[i]);
                backtrack(nums, used, curr);
                used[i] = false;
                curr.remove(curr.size() - 1);
            }
        }
    }

    public void dfs(int[] nums, HashSet<Integer> set, List<Integer> curr) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
                curr.add(num);
                dfs(nums, set, curr);
                set.remove(curr.get(curr.size() - 1));
                curr.remove(curr.size() - 1);
            }
        }
    }
}
