package dp;

import java.util.*;

public class MaximumScoreFromPerformingMultiplicationOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] mult = new int[m];

        for (int i = 0; i < m; i++) {
            mult[i] = sc.nextInt();
        }

        System.out.println(maximumScore(nums, mult));
    }

    static int[][] dp;

    public static int maximumScore(int[] nums, int[] mult) {
        int n = nums.length;
        int m = mult.length;

        dp = new int[m][m];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        return solve(nums, mult, 0, 0);
    }

    private static int solve(int[] arr, int[] mult, int s, int i) {
        int n = arr.length;
        int m = mult.length;

        int e = n - (i - s) - 1;

        if (s > e || i >= m) {
            return 0;
        }

        if (s == e) {
            return arr[s] * mult[i];
        }

        if (dp[s][i] != Integer.MIN_VALUE) {
            return dp[s][i];
        }

        return dp[s][i] = Math.max(arr[s] * mult[i] + solve(arr, mult, s + 1, i + 1), arr[e] * mult[i] + solve(arr, mult, s, i + 1));
    }
}
