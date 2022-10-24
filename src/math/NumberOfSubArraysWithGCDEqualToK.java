package math;

import java.util.*;

public class NumberOfSubArraysWithGCDEqualToK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(subarrayGCD(arr, k));
    }

    public static int subarrayGCD(int[] arr, int k) {
        int n = arr.length;

        int ct = 0;

        HashMap<Integer, Integer> prev = new HashMap<>();

        if (arr[0] == k) {
            ct++;
        }

        prev.put(arr[0], 1);

        for (int i = 1; i < n; i++) {
            HashMap<Integer, Integer> cur = new HashMap<>();

            for (Integer key : prev.keySet()) {
                int gcd = gcd(key, arr[i]);

                int f = prev.get(key);

                if (gcd == k) {
                    ct += f;
                }

                cur.put(gcd, cur.getOrDefault(gcd, 0) + f);
            }

            if (arr[i] == k) {
                ct++;
            }

            cur.put(arr[i], cur.getOrDefault(arr[i], 0) + 1);

            prev = cur;
        }


        return ct;
    }

    private static int gcd(int x, int y) {
        if (x == 0) {
            return y;
        }

        return gcd(y % x, x);
    }
}
