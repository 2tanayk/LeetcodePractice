package dp;

import java.util.*;

public class ArithmeticSlicesIISubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(numberOfArithmeticSlices(arr));
    }

    public static int numberOfArithmeticSlices(int[] arr) {
        int n = arr.length;

        HashMap<Long, Integer>[] dp = new HashMap[n];

        int ans = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long) arr[i] - (long) arr[j];
                int ct = dp[j].getOrDefault(diff, 0);
                dp[i].put(diff, dp[i].getOrDefault(diff, 0) + ct + 1);
                ans += ct;
            }
        }

        return ans;
    }
}
