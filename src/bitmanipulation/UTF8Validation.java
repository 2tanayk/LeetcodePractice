package bitmanipulation;

import java.util.*;

public class UTF8Validation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(validUtf8(arr));
    }

    public static boolean validUtf8(int[] arr) {
        int n = arr.length;

        int m1 = 1 << 7;
        int m2 = 7 << 5;
        int m3 = 15 << 4;
        int m4 = 31 << 3;

        for (int i = 0; i < n; ) {
            if ((arr[i] & m1) == 0) {
                i++;
            } else if ((arr[i] & m2) == (3 << 6)) {
                if (!check(arr, i + 1, 1)) {
                    return false;
                }
                i += 2;
            } else if ((arr[i] & m3) == (7 << 5)) {
                if (!check(arr, i + 1, 2)) {
                    return false;
                }
                i += 3;
            } else if ((arr[i] & m4) == (15 << 4)) {
                if (!check(arr, i + 1, 3)) {
                    return false;
                }
                i += 4;
            } else {
                return false;
            }
        }

        return true;
    }

    private static boolean check(int[] arr, int i, int ct) {
        int n = arr.length;
        int m = 3 << 6;

        while (ct-- > 0) {
            if (i >= n) {
                return false;
            }

            if ((arr[i] & m) != (1 << 7)) {
                return false;
            }
            i++;
        }

        return true;
    }
}
