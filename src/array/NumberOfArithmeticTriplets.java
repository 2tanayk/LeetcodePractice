package array;

import java.util.*;

public class NumberOfArithmeticTriplets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int diff = sc.nextInt();

        System.out.println(arithmeticTriplets(arr, diff));
    }

    public static int arithmeticTriplets(int[] arr, int diff) {
        int n = arr.length;

        int ct = 0;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            hm.put(arr[i], 1);
        }

        for (int i = 0; i < n; i++) {
            if (hm.containsKey(arr[i] + diff) && hm.containsKey(arr[i] + 2 * diff)) {
                ct++;
            }
        }

        return ct;
    }
}
