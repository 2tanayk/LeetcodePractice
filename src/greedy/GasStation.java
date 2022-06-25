package greedy;

import java.util.*;

public class GasStation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] gas = new int[n];
        int[] cost = new int[n];

        for (int i = 0; i < n; i++) {
            gas[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
        }

        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int diffSum = 0, gSum = 0, cSum = 0, pos = -1;

        for (int i = 0; i < n; i++) {
            gSum += gas[i];
            cSum += cost[i];

            diffSum += gas[i] - cost[i];
            if (diffSum < 0) {
                diffSum = 0;
                pos = -1;
            } else if (pos == -1) {
                pos = i;
            }
        }

        if (cSum > gSum) {
            return -1;
        }

        return pos;
    }
}
