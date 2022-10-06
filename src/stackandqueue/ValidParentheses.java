package stackandqueue;

import java.util.*;

public class ValidParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        int len = s.length();

        int i = 0;

        Stack<Integer> st = new Stack<>();

        while (i < len) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                st.push(i);
            } else {
                if (st.empty()) {
                    return false;
                } else {
                    char t = s.charAt(st.peek());

                    if (c == ')' && t == '(' || c == '}' && t == '{' || c == ']' && t == '[') {
                        st.pop();
                    } else {
                        return false;
                    }
                }
            }
            i++;
        }

        return st.empty();
    }
}
