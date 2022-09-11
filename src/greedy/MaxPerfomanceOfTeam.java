package greedy;

import java.util.*;

public class MaxPerfomanceOfTeam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] speed = new int[n];
        int[] efficiency = new int[n];

        for (int i = 0; i < n; i++) {
            speed[i] = sc.nextInt();
            efficiency[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(maxPerformance(n, speed, efficiency, k));
    }

    private static final long m = (long) Math.pow(10, 9) + 7;

    static class Pair {
        int s, e;

        Pair(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public static int maxPerformance(int n, int[] s, int[] e, int k) {
        Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(s[i], e[i]);
        }

        Arrays.sort(pairs, (p1, p2) -> p2.e - p1.e);

        long max = 0, sum = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.s - p2.s);

        for (int i = 0; i < n; i++) {
            if (pq.size() == k) {
                sum -= pq.poll().s;
            }

            Pair cur = pairs[i];
            sum += cur.s;
            max = Math.max(max, sum * cur.e);

            pq.add(cur);
        }

        return (int) (max % m);
    }
}
