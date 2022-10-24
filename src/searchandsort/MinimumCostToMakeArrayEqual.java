package searchandsort;

import java.util.*;

public class MinimumCostToMakeArrayEqual {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        int[] cost = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            cost[i] = sc.nextInt();
        }

        System.out.println(minCost(nums, cost));
    }

    public static long minCost(int[] nums, int[] cost) {
        int n = nums.length;

        long l = Integer.MIN_VALUE;
        long r = Integer.MAX_VALUE;

        for (int num : nums) {
            l = Math.min(l, num);
            r = Math.max(r, num);
        }

        long min = Integer.MAX_VALUE;


        while (l < r) {
            long mid = (l + r) / 2;

            long c1 = cost(nums, cost, mid);
            long c2 = cost(nums, cost, mid + 1);

            min = Math.min(c1, c2);

            if (c1 < c2) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return min;
    }

    private static long cost(int[] nums, int[] cost, long x) {
        long tot = 0;

        for (int i = 0; i < nums.length; i++) {
            tot += Math.abs(nums[i] - x) * cost[i];
        }

        return tot;
    }
}
