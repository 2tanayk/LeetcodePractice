package matrix;

import java.util.*;

public class RotateImage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        rotate(arr);
    }

    private static void rotate(int[][] arr) {
        int n = arr.length;

        int l = 0, r = n - 1, t = 0, b = n - 1;

        while (l < r) {
            rotateCornerElements(arr, l, r);
            rotateInnerElements(arr, l, r);

            l++;
            r--;
        }

        System.out.println(Arrays.deepToString(arr));
    }

    public static void rotateInnerElements(int[][] arr, int l, int r) {
        if (r - l - 1 <= 0) {
            return;
        }

        int[] el = new int[r - l - 1];

        for (int i = l + 1, j = 0; i <= r - 1; i++, j++) {
            el[j] = arr[l][i];
        }


        for (int i = l + 1, j = 0; i <= r - 1; i++, j++) {
            int temp = arr[i][r];
            arr[i][r] = el[j];
            el[j] = temp;
        }

        for (int i = r - 1, j = 0; i >= l + 1; i--, j++) {
            int temp = arr[r][i];
            arr[r][i] = el[j];
            el[j] = temp;
        }

        for (int i = r - 1, j = 0; i >= l + 1; i--, j++) {
            int temp = arr[i][l];
            arr[i][l] = el[j];
            el[j] = temp;
        }

        for (int i = l + 1, j = 0; i <= r - 1; i++, j++) {
            arr[l][i] = el[j];
        }

    }

    public static void rotateCornerElements(int[][] arr, int l, int r) {
        int topL = arr[l][l];
        int topR = arr[l][r];
        int botL = arr[r][l];
        int botR = arr[r][r];

        arr[l][r] = topL;
        arr[r][r] = topR;
        arr[r][l] = botR;
        arr[l][l] = botL;
    }
}
