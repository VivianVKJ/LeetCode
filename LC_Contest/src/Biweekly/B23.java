package Biweekly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class B23 {
    int ans;

    public static void main(String[] args) {
        System.out.println(countLargestGroup(13));

    }

    public static int countLargestGroup(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int sum = 0, copyn = i + 1;
            while (copyn != 0) {
                sum += copyn % 10;
                copyn /= 10;
            }
            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else map.put(sum, 1);
        }
        int max = 0, count = 0;
        for (int s : map.keySet()) {
            if (map.get(s) > max) {
                max = map.get(s);
                count = 1;
            } else if (map.get(s) == max)
                count++;
        }
        return count;
    }

    public static boolean canConstruct(String s, int k) {
        int[] ans = new int[1];
        backtrack(s, 0, k, new ArrayList<>(), ans);
        if (ans[0] > 0) return true;
        return false;
    }

    public static void backtrack(String s, int index, int k, List<String> curr, int[] ans) {
        if (index == s.length()) {
            if (curr.size() == k) ans[0]++;
        }
        for (int i = index; i < s.length(); i++) {
            String temp = s.substring(index, i + 1);
            if (isValid(temp)) {
                curr.add(temp);
                backtrack(s, i + 1, k, curr, ans);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public static boolean isValid(String sub) {
        for (int i = 0, j = sub.length() - 1; i < j; i++, j--) {
            //if(sub[i]!=sub[j]) return false;
            if (sub.charAt(i) != sub.charAt(j)) return false;
        }
        return true;
    }
}
