package greedy;

import java.util.*;

public class EarliestPossibleDayOfFullBloom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] plantTime = new int[n];

        for (int i = 0; i < n; i++) {
            plantTime[i] = sc.nextInt();
        }

        int[] growthTime = new int[n];

        for (int i = 0; i < n; i++) {
            growthTime[i] = sc.nextInt();
        }

        System.out.println(earliestFullBloom(plantTime, growthTime));
    }

    public static int earliestFullBloom(int[] pT, int[] gT) {
        int n = pT.length;

        List<int[]> c = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            c.add(new int[]{gT[i], pT[i]});
        }

        Collections.sort(c, (f1, f2) -> f1[0] - f2[0]);

        int res = 0;

        for (int[] f : c) {
            res = Math.max(res, f[0]);
            res += f[1];
        }

        return res;
    }
}
