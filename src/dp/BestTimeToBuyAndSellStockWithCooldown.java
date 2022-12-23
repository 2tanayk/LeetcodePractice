package dp;

import java.util.*;

public class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        System.out.println(maxProfit(prices));
    }

    static Integer[][] dp;

    public static int maxProfit(int[] prices) {
        int n = prices.length;

        dp = new Integer[n][1002];

        return solve(prices, 0, -1);
    }

    private static int solve(int[] a, int i, int pre) {
        int n = a.length;

        if (i >= n) {
            return 0;
        }

        if (dp[i][pre + 1] != null) {
            return dp[i][pre + 1];
        }

        if (pre == -1) {
            return dp[i][pre + 1] = Math.max(solve(a, i + 1, a[i]), solve(a, i + 1, -1));
        }

        if (pre != -1 && a[i] <= pre) {
            return dp[i][pre + 1] = solve(a, i + 1, pre);
        }

        return dp[i][pre + 1] = Math.max(a[i] - pre + solve(a, i + 2, -1), solve(a, i + 1, pre));
    }
}
