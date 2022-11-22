package graph;

import java.util.*;

public class PerfectSquares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(numSquares(n));
    }

    public static int numSquares(int n) {

        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> hs = new HashSet<>();

        hs.add(n);
        q.add(n);

        int tot = 0;


        while (!q.isEmpty()) {
            int ct = q.size();

            while (ct > 0) {
                int cur = q.poll();

                if (cur == 0) {
                    return tot;
                }

                int num = cur;

                while (num > 0) {
                    int sq = (int) Math.sqrt(num);
                    if (sq * sq != num || cur - num < 0 || hs.contains(cur - num)) {
                        num--;
                        continue;
                    }

                    hs.add(cur - num);
                    q.add(cur - num);

                    num--;
                }

                ct--;
            }

            tot++;
        }

        return n;
    }
}
