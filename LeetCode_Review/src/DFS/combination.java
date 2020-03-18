package DFS;

import java.util.ArrayList;
import java.util.List;

public class combination {
    List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        combination c = new combination();
        System.out.println(c.combine(4, 2).toString());
    }

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, new ArrayList<>(), 1);
        return ans;
    }

    public void backtrack(int n, int k, List<Integer> curr, int index) {
        if (curr.size() == k) {
            this.ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = index; i <= n; i++) {
            curr.add(i);
            backtrack(n, k, curr, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
