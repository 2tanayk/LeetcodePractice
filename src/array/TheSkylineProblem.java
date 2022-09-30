package array;

import java.util.*;

public class TheSkylineProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] buildings = new int[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                buildings[i][j] = sc.nextInt();
            }
        }

        System.out.println(getSkyline(buildings));
    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();

        ArrayList<int[]> heights = new ArrayList<>();

        for (int[] b : buildings) {
            heights.add(new int[]{b[0], -b[2]});
            heights.add(new int[]{b[1], b[2]});
        }

        Collections.sort(heights, (h1, h2) -> h1[0] == h2[0] ? h1[1] - h2[1] : h1[0] - h2[0]);

        TreeMap<Integer, Integer> tm = new TreeMap<>(Collections.reverseOrder());
        tm.put(0, 1);

        int prev = 0;

        for (int[] h : heights) {
            if (h[1] < 0) {
                tm.put(-h[1], tm.getOrDefault(-h[1], 0) + 1);
            } else {
                int f = tm.get(h[1]);
                if (f > 1) {
                    tm.put(h[1], f - 1);
                } else {
                    tm.remove(h[1]);
                }
            }

            int cur = tm.firstKey();

            if (cur != prev) {
                ans.add(Arrays.asList(h[0], cur));
                prev = cur;
            }
        }

        return ans;
    }
}
