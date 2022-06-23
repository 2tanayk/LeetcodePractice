package math;

import java.util.*;

public class XOfAKindInADeckOfCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(hasGroupsSizeX(arr));
    }

    private static boolean hasGroupsSizeX(int[] arr) {
        int n = arr.length;

        if (n < 2) {
            return false;
        }

        Arrays.sort(arr);

        int prev = 1;
        int i = 0;
        int e = arr[i];
        i++;

        while (i < n && arr[i] == e) {
            prev++;
            i++;
        }

        if (i >= n) {
            return true;
        }

        int cur = 1;
        e = arr[i];
        i++;

        while (i < n && arr[i] == e) {
            cur++;
            i++;
        }

        int curGcd = gcd(prev, cur);

        if (curGcd == 1) {
            return false;
        }

        while (i < n) {
            e = arr[i];
            cur = 1;
            i++;
            while (i < n && arr[i] == e) {
                cur++;
                i++;
            }

            curGcd = gcd(curGcd, cur);

            if (curGcd == 1) {
                return false;
            }
        }

        return true;
    }

    private static int gcd(int a, int b) {
        if (b > a) {
            int temp = b;
            b = a;
            a = temp;
        }

        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
