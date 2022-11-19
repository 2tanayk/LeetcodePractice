package dp;

import java.util.*;

public class HouseRobber2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(rob(nums));
    }

    public static int rob(int[] arr) {
        int n = arr.length;

        if (n == 1) {
            return arr[0];
        }

        return Math.max(solve(1, n - 1, arr), solve(0, n - 2, arr));
    }


    private static int solve(int l, int r, int[] arr) {
        int n = arr.length;

        int prev1 = arr[l], prev2 = -1;

        for (int i = l + 1; i <= r; i++) {
            int take = arr[i];

            if (i > l + 1) {
                take += prev2;
            }

            int dontTake = prev1;

            int cur = Math.max(take, dontTake);

            prev2 = prev1;
            prev1 = cur;
        }

        return prev1;
    }
}
