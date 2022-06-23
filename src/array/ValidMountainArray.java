package array;

import java.util.*;

public class ValidMountainArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(isValidMountainArray(arr));
    }

    private static boolean isValidMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            return false;
        }

        int max = arr[0];
        int j = -1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] == max) {
                return false;
            } else {
                j = i;
                break;
            }
        }

        if (j == -1 || j == 1) {
            return false;
        }

        int min = arr[j];

        for (int i = j + 1; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else {
                return false;
            }
        }

        return true;
    }
}
