package greedy;

import java.util.*;

public class MinMoneyRequiredBeforeTransactions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] transactions = new int[n][2];

        for (int i = 0; i < n; i++) {
            transactions[i][0] = sc.nextInt();
            transactions[i][1] = sc.nextInt();
        }

        System.out.println(minimumMoney(transactions));
    }

    public static long minimumMoney(int[][] arr) {
        int maxCb = 0, maxCst = 0;

        long sumL = 0;

        for (int[] ts : arr) {
            if (ts[0] > ts[1]) {
                maxCb = Math.max(maxCb, ts[1]);
                sumL += ts[0] - ts[1];
            } else {
                maxCst = Math.max(maxCst, ts[0]);
            }
        }

        return sumL + Math.max(maxCb, maxCst);
    }
}
