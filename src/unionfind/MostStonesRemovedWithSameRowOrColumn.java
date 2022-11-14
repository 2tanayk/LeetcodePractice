package unionfind;

import java.util.*;

public class MostStonesRemovedWithSameRowOrColumn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] stones = new int[n][2];

        for (int i = 0; i < n; i++) {
            stones[i][0] = sc.nextInt();
            stones[i][1] = sc.nextInt();
        }

        System.out.println(removeStones(stones));
    }

    public static int removeStones(int[][] st) {
        int n = st.length;

        int[] p = new int[n];

        for (int i = 0; i < n; i++) {
            p[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (st[i][0] == st[j][0] || st[i][1] == st[j][1]) {
                    union(p, i, j);
                }
            }
        }

        int ct = 0;

        for (int i = 0; i < n; i++) {
            if (i == p[i]) {
                ct++;
            }
        }

        return n - ct;
    }

    private static void union(int[] p, int s1, int s2) {
        int r1 = find(p, s1);
        int r2 = find(p, s2);

        if (r1 == r2) {
            return;
        }

        p[r1] = r2;
    }

    private static int find(int[] p, int s) {
        if (p[s] != s) {
            p[s] = find(p, p[s]);
        }

        return p[s];
    }
}
