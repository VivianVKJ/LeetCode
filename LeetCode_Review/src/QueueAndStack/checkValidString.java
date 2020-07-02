package QueueAndStack;

import java.util.Stack;

public class checkValidString {
    public static void main(String[] args) {
        String s = "(*()";
        System.out.println(checkValidString(s) == true ? "True" : "False");
    }

    public static boolean checkValidString(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> star = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(c);
            else if (c == ')') {
                if (stack.empty() && star.empty()) return false;
                else {
                    if (!stack.empty() && stack.peek() == '(') stack.pop();
                    else if (!star.empty()) star.pop();
                    else return false;
                }
            } else star.push(c);
        }
        while (!stack.empty() && !star.empty()) {
            stack.pop();
            star.pop();
        }
        return stack.empty();
    }
}
