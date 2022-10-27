package matrix;

import java.util.*;

public class ImageOverlap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] img1 = new int[n][n];
        int[][] img2 = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                img1[i][j] = sc.nextInt();
                img2[i][j] = sc.nextInt();
            }
        }

        System.out.println(largestOverlap(img1, img2));
    }

    public static int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;

        List<int[]> p1 = new ArrayList<>();
        List<int[]> p2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) {
                    p1.add(new int[]{i, j});
                }

                if (img2[i][j] == 1) {
                    p2.add(new int[]{i, j});
                }
            }
        }

        HashMap<String, Integer> hm = new HashMap<>();
        int max = 0;

        for (int[] a : p1) {
            for (int[] b : p2) {
                String diff = (a[0] - b[0]) + "," + (a[1] - b[1]);

                hm.put(diff, hm.getOrDefault(diff, 0) + 1);

                max = Math.max(max, hm.get(diff));
            }
        }

        return max;
    }
}
