package dp;

import java.util.*;

public class NoOfDiceRollsWithTargetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int target = sc.nextInt();

        System.out.println(numRollsToTarget(n, k, target));
    }

    static int[][] dp;
    private static final int m = (int) Math.pow(10, 9) + 7;

    public static int numRollsToTarget(int n, int k, int target) {
        dp = new int[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return count(n, k, 1, target);
    }

    private static int count(int n, int k, int no, int target) {
        if (no == n + 1 && target == 0) {
            return 1;
        }

        if (no == n + 1 || target == 0) {
            return 0;
        }

        if (dp[no][target] != -1) {
            return dp[no][target];
        }

        int ct = 0;

        for (int j = 1; j <= k; j++) {
            if (target < j) {
                break;
            }
            ct = (ct + count(n, k, no + 1, target - j)) % m;
        }

        return dp[no][target] = ct;
    }
}
