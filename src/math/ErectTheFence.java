package math;

import java.util.*;

public class ErectTheFence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] trees = new int[n][2];

        for (int i = 0; i < n; i++) {
            trees[i][0] = sc.nextInt();
            trees[i][1] = sc.nextInt();
        }

        System.out.println(Arrays.deepToString(outerTrees(trees)));
    }

    public static int[][] outerTrees(int[][] trees) {
        Arrays.sort(trees, (t1, t2) -> t1[0] != t2[0] ? t1[0] - t2[0] : t1[1] - t2[1]);

        System.out.println(Arrays.deepToString(trees));

        HashSet<int[]> hs = new HashSet<>();

        List<int[]> st = new ArrayList<>();

        for (int[] t : trees) {
            int size = st.size();

            while (size >= 2 && cross(st.get(size - 2), st.get(size - 1), t) > 0) {
                st.remove(size - 1);
                size = st.size();
            }
            st.add(t);
        }

        while (!st.isEmpty()) {
            hs.add(st.get(st.size() - 1));
            st.remove(st.size() - 1);
        }

        for (int i = trees.length - 1; i >= 0; i--) {
            int[] t = trees[i];
            int size = st.size();

            while (size >= 2 && cross(st.get(size - 2), st.get(size - 1), t) > 0) {
                st.remove(size - 1);
                size = st.size();
            }
            st.add(t);
        }

        while (!st.isEmpty()) {
            hs.add(st.get(st.size() - 1));
            st.remove(st.size() - 1);
        }

        int[][] ans = new int[hs.size()][2];

        int i = 0;

        for (int[] t : hs) {
            ans[i++] = t;
        }

        return ans;
    }

    private static int cross(int[] p1, int[] p2, int[] p3) {
        int a = p2[0] - p1[0];
        int b = p2[1] - p1[1];
        int c = p3[0] - p1[0];
        int d = p3[1] - p1[1];

        return a * d - b * c;
    }
}
