package dp;

import java.util.*;

public class SingleNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(singleNumber(arr));
    }

    public static int singleNumber(int[] arr) {
        int n = arr.length;
        int xor = arr[0];

        for (int i = 1; i < n; i++) {
            xor ^= arr[i];
        }

        return xor;
    }
}
