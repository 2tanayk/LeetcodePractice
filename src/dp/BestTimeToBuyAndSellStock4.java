package dp;

import java.util.*;

public class BestTimeToBuyAndSellStock4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(maxProfit(k, arr));
    }

    static int[][][] dp;

    public static int maxProfit(int k, int[] arr) {
        int n = arr.length;
        dp = new int[n][k + 1][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }

        return solve(arr, 0, 1, k);
    }

    private static int solve(int[] arr, int i, int bFlag, int k) {
        int n = arr.length;

        if (i == n || k == 0) {
            return 0;
        }

        if (dp[i][k][bFlag] != Integer.MIN_VALUE) {
            return dp[i][k][bFlag];
        }

        if (bFlag == 1) {
            return dp[i][k][bFlag] = Math.max(-arr[i] + solve(arr, i + 1, 0, k), solve(arr, i + 1, 1, k));
        }

        return dp[i][k][bFlag] = Math.max(arr[i] + solve(arr, i + 1, 1, k - 1), solve(arr, i + 1, 0, k));
    }
}
