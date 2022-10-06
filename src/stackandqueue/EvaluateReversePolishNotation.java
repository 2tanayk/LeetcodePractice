package stackandqueue;

import java.util.*;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String[] tokens = new String[n];
        for (int i = 0; i < n; i++) {
            tokens[i] = sc.nextLine();
        }

        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String t : tokens) {
            if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
                int res;
                int b = st.pop();
                int a = st.pop();

                if (t.equals("+")) {
                    res = a + b;
                } else if (t.equals("-")) {
                    res = a - b;
                } else if (t.equals("*")) {
                    res = a * b;
                } else {
                    res = a / b;
                }

                st.push(res);
            } else {
                st.push(Integer.parseInt(t));
            }
        }

        return st.pop();
    }
}
