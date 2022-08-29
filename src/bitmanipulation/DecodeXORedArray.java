package bitmanipulation;

import java.util.*;

public class DecodeXORedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int first = sc.nextInt();

        System.out.println(Arrays.toString(decode(arr, first)));
    }

    public static int[] decode(int[] e, int first) {
        int[] arr = new int[e.length + 1];

        arr[0] = first;

        for (int i = 0; i < e.length; i++) {
            arr[i + 1] = arr[i] ^ e[i];
        }

        return arr;
    }
}
