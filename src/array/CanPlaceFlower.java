package array;

import java.util.Scanner;

public class CanPlaceFlower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int m = sc.nextInt();

        System.out.println(canPlaceFlowers(arr, m));
    }

    private static boolean canPlaceFlowers(int[] arr, int n) {
        if (n == 0) {
            return true;
        }

        int len = arr.length;

        if (arr[0] == 0 && len == 1) {
            return n == 1;
        }

        if (arr[0] == 1 && len == 1) {
            return false;
        }

        int pCt = 0;

        if (arr[0] == 0 && arr[1] == 0) {
            arr[0] = 1;
            pCt++;
        }

        for (int i = 1; i < len - 1; ) {
            if (arr[i] == 0 && arr[i - 1] == 0 && arr[i + 1] == 0) {
                arr[i] = 1;
                pCt++;
                i += 2;
            } else {
                i++;
            }

            if (pCt == n) {
                return true;
            }
        }

        if (arr[len - 2] == 0 && arr[len - 1] == 0) {
            pCt++;
        }

        return pCt == n;
    }
}
