package math;

import java.util.*;

public class UglyNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(isUgly(n));
    }

    public static boolean isUgly(int n) {
        int d = 2;

        if (n <= 0) {
            return false;
        }

        while (d < 6) {
            if (n % d == 0) {
                n /= d;
            } else {
                d++;
            }
        }

        return n == 1;
    }
}
