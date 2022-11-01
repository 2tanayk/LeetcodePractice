package dp;

import java.util.*;

public class WhereWillTheBallFall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(Arrays.toString(findBall(arr)));
    }

    static Integer[][] dp;

    public static int[] findBall(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        dp = new Integer[m + 1][n + 1];

        int[] ans = new int[n];

        for (int k = 0; k < n; k++) {
            ans[k] = solve(arr, 0, k);
        }

        return ans;
    }

    private static int solve(int[][] arr, int i, int j) {
        int m = arr.length;
        int n = arr[0].length;

        if (i == m) {
            return j;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (arr[i][j] == 1 && j + 1 < n && arr[i][j + 1] != -1) {
            return dp[i][j] = solve(arr, i + 1, j + 1);
        }

        if (arr[i][j] == -1 && j - 1 >= 0 && arr[i][j - 1] != 1) {
            return dp[i][j] = solve(arr, i + 1, j - 1);
        }

        return dp[i][j] = -1;
    }
}
