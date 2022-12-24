package dp;

import java.util.*;

public class DominoAndTrominoTiling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(numTilings(n));
    }

    public static int numTilings(int n) {
        long[] dp = new long[1001];

        long m = (long) Math.pow(10, 9) + 7;

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        if (n <= 3) {
            return (int) dp[n];
        }

        for (int i = 4; i <= n; i++) {
            dp[i] = 2 * dp[i - 1] + dp[i - 3];
            dp[i] %= m;
        }

        return (int) dp[n];
    }
}
