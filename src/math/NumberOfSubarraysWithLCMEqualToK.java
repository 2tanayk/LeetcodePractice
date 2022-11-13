package math;

import java.util.*;

public class NumberOfSubarraysWithLCMEqualToK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(subarrayLCM(arr, k));
    }

    public static int subarrayLCM(int[] arr, int k) {
        int n = arr.length;

        int ct = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == k) {
                ct++;
            }
            int prev = arr[i];
            for (int j = i + 1; j < n; j++) {
                int lcm = lcm(prev, arr[j]);
                if (lcm == k) {
                    ct++;
                }
                if (lcm > k) {
                    break;
                }
                prev = lcm;
            }
        }

        return ct;
    }

    private static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }

        return gcd(b % a, a);
    }

    private static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
}
