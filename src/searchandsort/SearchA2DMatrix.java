package searchandsort;

import java.util.*;

public class SearchA2DMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int target = sc.nextInt();

        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] arr, int target) {
        int m = arr.length;
        int n = arr[0].length;

        int lr = 0, hr = m - 1;

        while (lr <= hr) {
            int mr = (lr + hr) / 2;

            int lc = 0, hc = n - 1;

            while (lc <= hc) {
                int mc = (lc + hc) / 2;

                if (arr[mr][mc] == target) {
                    return true;
                } else if (arr[mr][mc] > target) {
                    hc = mc - 1;
                } else {
                    lc = mc + 1;
                }
            }

            if (hc + 1 > 0 && hc + 1 < n) {
                break;
            }

            if (hc + 1 == 0) {
                hr = mr - 1;
            } else {
                lr = mr + 1;
            }
        }

        return false;
    }
}
