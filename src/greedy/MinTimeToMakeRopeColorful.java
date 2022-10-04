package greedy;

import java.util.*;

public class MinTimeToMakeRopeColorful {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String colors = sc.nextLine();

        int n = sc.nextInt();

        int[] neededTime = new int[n];

        for (int i = 0; i < n; i++) {
            neededTime[i] = sc.nextInt();
        }

        System.out.println(minCost(colors, neededTime));
    }

    public static int minCost(String col, int[] time) {
        int len = col.length();

        int ans = 0;

        int i = 0;

        while (i + 1 < len) {
            char cur = col.charAt(i);
            char nxt = col.charAt(i + 1);

            if (cur == nxt) {
                int max = 0;

                while (i + 1 < len) {
                    cur = col.charAt(i);
                    nxt = col.charAt(i + 1);

                    ans += time[i];
                    max = Math.max(max, time[i]);

                    if (cur != nxt) {
                        break;
                    }

                    if (i == len - 2) {
                        ans += time[i + 1];
                        max = Math.max(max, time[i + 1]);
                    }

                    i++;
                }

                ans -= max;
            }

            i++;
        }

        return ans;
    }
}
