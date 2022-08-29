package array;

import java.util.*;

public class ShuffleTheArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(shuffle(arr, n)));
    }

    public static int[] shuffle(int[] arr, int n) {
        int[] ans = new int[2 * n];

        for (int i = 1; i <= n; i++) {
            ans[(i - 1) * 2] = arr[i - 1];
        }

        for (int i = 1; i <= n; i++) {
            ans[1 + (i - 1) * 2] = arr[n + i - 1];
        }

        return ans;
    }
}
