package dp;

import java.util.*;

public class ScrambleString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        System.out.println(isScramble(s1, s2));
    }

    static HashMap<String, Boolean> dp;

    public static boolean isScramble(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (n != m) {
            return false;
        }

        if (s1.equals(s2)) {
            return true;
        }

        dp = new HashMap<>();

        return solve(s1, s2);
    }

    private static boolean solve(String s1, String s2) {
        int n = s1.length();

        if (s1.equals(s2)) {
            return true;
        }

        if (n <= 1) {
            return false;
        }

        String key = s1 + "$" + s2;

        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        for (int i = 1; i <= n - 1; i++) {
            boolean same = solve(s1.substring(0, i), s2.substring(0, i)) && solve(s1.substring(i), s2.substring(i));
            boolean swap = solve(s1.substring(0, i), s2.substring(n - i)) && solve(s1.substring(i), s2.substring(0, n - i));

            if (same || swap) {
                dp.put(key, true);
                return dp.get(key);
            }
        }

        dp.put(key, false);

        return dp.get(key);
    }
}
