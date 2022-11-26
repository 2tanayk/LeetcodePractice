package dp;

import java.util.*;

public class MaximumProfitInJobScheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] startTime = new int[n];
        int[] endTime = new int[n];
        int[] profit = new int[n];

        for (int i = 0; i < n; i++) {
            startTime[i] = sc.nextInt();
            endTime[i] = sc.nextInt();
            profit[i] = sc.nextInt();
        }

        System.out.println(jobScheduling(startTime, endTime, profit));
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        List<int[]> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new int[]{startTime[i], endTime[i], profit[i]});
        }

        Collections.sort(jobs, (e1, e2) -> e1[1] - e2[1]);

        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0);

        for (int[] job : jobs) {
            int cur = dp.floorEntry(job[0]).getValue() + job[2];

            if (cur > dp.lastEntry().getValue()) {
                dp.put(job[1], cur);
            }
        }

        return dp.lastEntry().getValue();
    }
}
