package array;

import java.util.*;

public class NumberOfUnequalTriplets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(unequalTriplets(arr));
    }

    public static int unequalTriplets(int[] arr) {
        int n = arr.length;

        int ct = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] != arr[j] && arr[i] != arr[k] && arr[j] != arr[k]) {
                        ct++;
                    }
                }
            }
        }

        return ct;
    }
}
