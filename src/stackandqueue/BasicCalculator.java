package stackandqueue;

import java.util.*;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        Stack<Integer> st = new Stack<>();

        int num = 0, res = 0, sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = 10 * num + (int) (c - '0');
            } else if (c == '+') {
                res += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                res += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                st.push(res);
                st.push(sign);

                res = 0;
                sign = 1;
            } else if (c == ')') {
                res += sign * num;

                num = 0;

                res *= st.pop();
                res += st.pop();
            }
        }

        if (num != 0) {
            res += sign * num;
        }

        return res;
    }
}
