package string;

import java.util.*;

public class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(removeDuplicates(s));
    }

    public static String removeDuplicates(String s) {
        int len = s.length();

        Stack<Character> st = new Stack<>();
        st.push('$');

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            char t = st.peek();

            if (c == t) {
                st.pop();
            } else {
                st.push(c);
            }
        }

        StringBuilder ans = new StringBuilder();

        while (st.size() != 1) {
            ans.append(st.pop());
        }

        return ans.reverse().toString();
    }
}
