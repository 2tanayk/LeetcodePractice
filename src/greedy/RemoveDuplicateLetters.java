package greedy;

import java.util.*;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(removeDuplicateLetters(s));
    }

    private static String removeDuplicateLetters(String s) {
        int len = s.length();

        StringBuilder ans = new StringBuilder();

        Stack<Character> st = new Stack<>();
        HashMap<Character, Integer> fm = new HashMap<>();
        HashMap<Character, Boolean> vm = new HashMap<>();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            fm.put(ch, fm.getOrDefault(ch, 0) + 1);
        }

        for (char ch : fm.keySet()) {
            vm.put(ch, false);
        }

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            fm.put(ch, fm.get(ch) - 1);

            if (vm.get(ch)) {
                continue;
            }

            while (!st.empty() && st.peek() > ch && fm.get(st.peek()) > 0) {
                char top = st.pop();
                vm.put(top, false);
            }

            st.push(ch);
            vm.put(ch, true);
        }


        while (!st.empty()) {
            ans.append(st.pop());
        }

        ans.reverse();

        return ans.toString();
    }
}
