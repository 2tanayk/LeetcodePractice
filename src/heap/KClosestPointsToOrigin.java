package heap;

import java.util.*;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] points = new int[n][2];

        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(Arrays.deepToString(kClosest(points, k)));
    }

    public static int[][] kClosest(int[][] p, int k) {
        int[][] ans = new int[k][2];

        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (i1, i2) -> Double.compare(dist(p[i2][0], p[i2][1]), dist(p[i1][0], p[i1][1])));


        for (int i = 0; i < p.length; i++) {
            int[] pt = p[i];

            if (pq.size() < k) {
                pq.add(i);
            } else {
                int t = pq.peek();

                if (dist(pt[0], pt[1]) < dist(p[t][0], p[t][1])) {
                    pq.poll();
                    pq.add(i);
                }
            }
        }

        for (int i = 0; i < k; i++) {
            ans[i] = p[pq.poll()];
        }

        return ans;
    }

    private static double dist(int x, int y) {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}
