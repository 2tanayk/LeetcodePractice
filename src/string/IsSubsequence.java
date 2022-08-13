package string;

import java.util.*;

public class IsSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String p = sc.nextLine();

        System.out.println(isSubsequence(p, s));
    }

    public static boolean isSubsequence(String pat, String s) {
        int n = s.length();
        int m = pat.length();

        return solve(s, n, pat, m);
    }

    private static boolean solve(String s, int n, String p, int m) {
        if (m == 0) {
            return true;
        }

        if (n == 0) {
            return false;
        }

        if (s.charAt(n - 1) == p.charAt(m - 1)) {
            return solve(s, n - 1, p, m - 1);
        }

        return solve(s, n - 1, p, m);
    }
}
