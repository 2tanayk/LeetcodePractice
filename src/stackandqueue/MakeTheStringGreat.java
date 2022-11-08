package stackandqueue;

import java.util.*;

public class MakeTheStringGreat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(makeGood(s));
    }

    public static String makeGood(String s) {
        int len = s.length();

        if (len == 1) {
            return s;
        }

        Stack<Character> st = new Stack<>();

        st.push('$');
        st.push(s.charAt(0));

        int i = 1;

        while (i < len) {
            char c = s.charAt(i);
            char top = st.peek();

            if (top != c && Character.toLowerCase(c) == Character.toLowerCase(top)) {
                st.pop();
            } else {
                st.push(c);
            }
            i++;
        }

        StringBuilder sb = new StringBuilder();

        while (st.size() != 1) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}
