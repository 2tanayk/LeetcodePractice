package array;

import java.util.*;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;

        int l = 0, r = l + 1;

        int max = 0;

        while (r < n) {
            if (prices[l] < prices[r]) {
                max = Math.max(max, prices[r] - prices[l]);
            } else {
                l = r;
            }
            r++;
        }

        return max;
    }
}
