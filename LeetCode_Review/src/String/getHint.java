package String;

import java.util.HashSet;

public class getHint {
    public static void main(String[] args) {
        System.out.println(getHint("1122", "2211"));
    }

    public static String getHint(String secret, String guess) {
        int[] nums = new int[10];
        int A = 0, B = 0;
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i), g = guess.charAt(i);
            if (s == g) A++;
            else {
                if (nums[s - '0']++ < 0) B++;
                if (nums[g - '0']-- > 0) B++;
            }
        }
        return A + "A" + B + "B";
    }

    public static String getHint_twopass(String secret, String guess) {
        int A = 0, B = 0;
        HashSet<Character> gset = new HashSet<>();
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                A += 1;
                secret = secret.substring(0, i) + "#" + secret.substring(i + 1);
            } else gset.add(guess.charAt(i));
        }
        for (Character c : secret.toCharArray())
            if (gset.contains(c)) {
                B += 1;
                gset.remove(c);
            }
        return A + "A" + B + "B";
    }
}
