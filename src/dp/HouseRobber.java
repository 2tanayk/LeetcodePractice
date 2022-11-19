package dp;

import java.util.*;

public class HouseRobber {
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

        int prev1 = arr[0], prev2 = -1;

        for (int i = 1; i < n; i++) {
            int take = arr[i];

            if (i > 1) {
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
