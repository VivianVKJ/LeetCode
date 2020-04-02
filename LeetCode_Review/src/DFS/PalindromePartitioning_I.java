package DFS;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_I {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0, new ArrayList<>());
        return ans;
    }

    public void backtrack(String s, int index, List<String> curr) {
        if (index == s.length()) {
            this.ans.add(new ArrayList<>(curr));
            for (String str : curr) System.out.print(str + "  ");
            System.out.println(" ");
        }
        for (int i = index; i < s.length(); i++) {
            String temp = s.substring(index, i + 1);
            if (isValid(temp)) {
                curr.add(temp);
                backtrack(s, i + 1, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public boolean isValid(String sub) {
        for (int i = 0, j = sub.length() - 1; i < j; i++, j--) {
            //if(sub[i]!=sub[j]) return false;
            if (sub.charAt(i) != sub.charAt(j)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning_I p = new PalindromePartitioning_I();
        p.partition("aab");
    }

}
