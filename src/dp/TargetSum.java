package dp;

import java.util.*;

public class TargetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        System.out.println(findTargetSumWays(arr, target));
    }

    public static int findTargetSumWays(int[] arr, int target) {
        int n = arr.length;

        if (n == 1) {
            return arr[0] == target || arr[0] == -target ? 1 : 0;
        }


        int tot = 0;

        for (int i = 0; i < n; i++) {
            tot += arr[i];
        }

        if (tot < Math.abs(target) || (tot + target) % 2 != 0) {
            return 0;
        }

        int req = (tot + target) / 2;

        int[][] dp = new int[n + 1][req + 1];

        for (int i = 1; i < req + 1; i++) {
            dp[0][i] = 0;
        }

        dp[0][0] = 1;

        int ct = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                ct++;
            }

            dp[i + 1][0] = (int) Math.pow(2, ct);
        }


        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < req + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }


        return dp[n][req];
    }
}
