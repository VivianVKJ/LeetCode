package String;

import java.util.HashSet;

public class lastSubstring {
    public static void main(String[] args) {
        String n = "abcxacxxbxab";
        String s = "aaaaaa";
        System.out.println(lastSubString(n));
    }

    public static String lastSubString(String s) {
        char max = 'a';
        HashSet<Integer> candidate = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c > max) {
                max = c;
                candidate.clear();
                candidate.add(i);
            } else if (max == c) candidate.add(i);
        }
        int len = 1;
        while (candidate.size() > 1) {
            char maxc = 'a';
            HashSet<Integer> remove = new HashSet<>();
            for (int can : candidate) {
                if ((can + len) == s.length() || (can != 0 && s.charAt(can - 1) == s.charAt(can))) remove.add(can);
                else if (s.charAt(can + len) > maxc)
                    maxc = s.charAt(can + len); //max extended candidate
            }
            for (int can : candidate) if (!remove.contains(can) && s.charAt(can + len) < maxc) remove.add(can);
            if (remove.size() == candidate.size()) break;
            for (int r : remove) candidate.remove(r);
            len += 1;
        }
        String ans = "";
        for (int can : candidate) {
            ans = ans.compareTo(s.substring(can)) < 0 ? s.substring(can) : ans;
        }
        return ans;
    }
}
