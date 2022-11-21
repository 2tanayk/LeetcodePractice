package greedy;

import java.util.*;

public class OverlappingIntervals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] intervals = new int[n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 3; j++) {
                intervals[i][j] = sc.nextInt();
            }
        }

        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] in) {
        Arrays.sort(in, (i1, i2) -> i1[0] != i2[0] ? i1[0] - i2[0] : i1[1] - i2[1]);

        int end = in[0][1];

        int ct = 0;

        for (int i = 1; i < in.length; i++) {
            if (in[i][0] >= end) {
                end = in[i][1];
            } else {
                ct++;
                end = Math.min(end, in[i][1]);
            }
        }

        return ct;
    }
}
