package dp;

import java.util.*;

public class DecodeWays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(numDecodings(s));
    }

    static int[] dp;

    public static int numDecodings(String s) {
        int len = s.length();
        dp = new int[len];

        Arrays.fill(dp, -1);

        return solve(s, 0);
    }

    private static int solve(String s, int i) {
        int len = s.length();

        if (i == len) {
            return 1;
        }

        if (s.charAt(i) == '0') {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int res = solve(s, i + 1);

        if (i < len - 1) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);

            if (c1 == '1' || c1 == '2' && c2 <= '6') {
                res += solve(s, i + 2);
            }
        }

        return dp[i] = res;
    }
}
