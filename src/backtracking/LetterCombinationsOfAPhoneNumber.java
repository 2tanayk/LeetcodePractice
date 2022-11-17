package backtracking;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String digits = sc.nextLine();

        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        int len = digits.length();

        if (len == 0) {
            return ans;
        }

        solve(digits, 0, new StringBuilder(), ans);

        return ans;
    }

    private static void solve(String d, int i, StringBuilder sb, List<String> ans) {
        int len = d.length();

        if (i == len) {
            ans.add(sb.toString());
            return;
        }

        int dig = d.charAt(i) - '0';

        int ct = dig != 9 && dig != 7 ? 3 : 4;

        int st;

        if (dig <= 7) {
            st = 3 * (dig - 2);
        } else {
            st = 3 * (dig - 2) + 1;
        }

        int en = st + ct;

        for (int j = st; j < en; j++) {
            sb.append((char) ('a' + j));
            solve(d, i + 1, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
