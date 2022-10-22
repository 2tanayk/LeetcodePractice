package dp;

import java.util.*;

public class MinimumDifficultyOfJobSchedule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] jobDifficulty = new int[n];

        for (int i = 0; i < n; i++) {
            jobDifficulty[i] = sc.nextInt();
        }

        int d = sc.nextInt();

        System.out.println(minDifficulty(jobDifficulty, d));
    }

    static Integer[][] dp;

    public static int minDifficulty(int[] jd, int d) {
        int n = jd.length;

        if (d > n) {
            return -1;
        }

        dp = new Integer[n][d + 1];

        return solve(jd, 0, d);
    }

    private static int solve(int[] arr, int i, int d) {
        int n = arr.length;

        if (i == n && d == 0) {
            return 0;
        }

        if (i == n || d == 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[i][d] != null) {
            return dp[i][d];
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int j = i; j < n; j++) {
            max = Math.max(max, arr[j]);

            int temp = solve(arr, j + 1, d - 1);

            if (temp != Integer.MAX_VALUE) {
                min = Math.min(min, max + temp);
            }
        }

        return dp[i][d] = min;
    }
}
