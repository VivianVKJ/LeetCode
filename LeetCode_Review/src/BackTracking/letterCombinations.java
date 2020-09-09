package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class letterCombinations {
    static List<String> ans = new ArrayList<>();
    static List<String> board;

    public static void main(String[] args) {
        System.out.println(letterCombinations("23").toString());
    }

    public static List<String> letterCombinations(String digits) {
        String[] keyboard = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        board = Arrays.asList(keyboard);
        permute(digits, "");
        return ans;
    }

    public static void permute(String digits, String curr) {
        if (curr.length() == digits.length()) {
            ans.add(curr);
            return;
        }
        int key = digits.charAt(curr.length()) - '2';
        for (int i = 0; i < board.get(key).length(); i++) {
            permute(digits, curr + board.get(key).charAt(i));
        }
        return;
    }
}
