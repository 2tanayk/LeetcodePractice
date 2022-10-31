package matrix;

import java.util.*;

public class ToeplitzMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(isToeplitzMatrix(arr));
    }

    public static boolean isToeplitzMatrix(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        for (int i = 0; i < n; i++) {
            if (!check(arr, 0, i)) {
                return false;
            }
        }

        for (int i = 0; i < m; i++) {
            if (!check(arr, i, 0)) {
                return false;
            }
        }

        return true;
    }

    private static boolean check(int[][] arr, int r, int c) {
        int m = arr.length;
        int n = arr[0].length;

        int e = arr[r++][c++];

        while (r < m && c < n) {
            if (arr[r][c] != e) {
                return false;
            }
            r++;
            c++;
        }

        return true;
    }
}
