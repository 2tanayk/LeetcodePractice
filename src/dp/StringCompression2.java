package dp;

import java.util.*;

public class StringCompression2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int k = sc.nextInt();

        System.out.println(getLengthOfOptimalCompression(s, k));
    }

    static Integer[][] dp;

    public static int getLengthOfOptimalCompression(String s, int k) {
        dp = new Integer[s.length()][k + 1];

        return solve(s, 0, k);
    }

    private static int solve(String s, int i, int k) {
        int len = s.length();

        if (k < 0) {
            return len;
        }

        if (len <= i + k) {
            return 0;
        }

        if (dp[i][k] != null) {
            return dp[i][k];
        }

        char c = s.charAt(i);

        int min = solve(s, i + 1, k - 1);
        int same = 0, diff = 0, rLen = 0;

        for (int j = i; j < len && diff <= k; j++) {
            char cur = s.charAt(j);

            if (c == cur) {
                same++;

                if (same <= 2 || same == 10 || same == 100) {
                    rLen++;
                }
            } else {
                diff++;
            }

            min = Math.min(min, rLen + solve(s, j + 1, k - diff));
        }

        return dp[i][k] = min;
    }
}
