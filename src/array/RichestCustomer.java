package array;

import java.util.*;

public class RichestCustomer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(maximumWealth(arr));
    }

    public static int maximumWealth(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int max = 0;

        for (int i = 0; i < n; i++) {
            int cur = 0;
            for (int j = 0; j < m; j++) {
                cur += arr[i][j];
            }
            max = Math.max(max, cur);
        }

        return max;
    }
}
