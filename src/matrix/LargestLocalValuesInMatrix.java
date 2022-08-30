package matrix;

import java.util.*;

public class LargestLocalValuesInMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(Arrays.deepToString(largestLocal(arr)));
    }

    public static int[][] largestLocal(int[][] arr) {
        int n = arr.length;

        int[][] ans = new int[n - 2][n - 2];

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                ans[i][j] = getHighest(arr, i, j);
            }
        }

        return ans;
    }

    private static int getHighest(int[][] arr, int r, int c) {
        int max = 0;

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                max = Math.max(max, arr[i][j]);
            }
        }

        return max;
    }
}
