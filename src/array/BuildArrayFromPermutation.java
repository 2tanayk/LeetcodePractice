package array;

import java.util.*;

public class BuildArrayFromPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(buildArray(arr)));
    }

    public static int[] buildArray(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            arr[i] = (arr[arr[i]] % n) * n + arr[i];
        }

        for (int i = 0; i < n; i++) {
            arr[i] /= n;
        }

        return arr;
    }
}
