package dp;

import java.util.*;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(canPartition(arr));
    }

    static Boolean[][] dp;

    public static boolean canPartition(int[] arr) {
        int n = arr.length;

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        dp = new Boolean[n][sum / 2 + 1];

        return solve(arr, n - 1, sum / 2);
    }

    private static boolean solve(int[] arr, int i, int sum) {
        int n = arr.length;

        if (sum == 0) {
            return true;
        }

        if (i < 0) {
            return false;
        }

        if (dp[i][sum] != null) {
            return dp[i][sum];
        }

        if (sum < arr[i]) {
            return dp[i][sum] = solve(arr, i - 1, sum);
        }

        return dp[i][sum] = solve(arr, i - 1, sum - arr[i]) || solve(arr, i - 1, sum);
    }
}
