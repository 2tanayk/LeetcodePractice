package math;

import java.util.*;

public class ReverseInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        int sign = x > 0 ? 1 : -1;

        x = Math.abs(x);

        int res = 0;

        while (x > 0) {
            int d = x % 10;

            int newRes = res * 10 + d;

            if ((newRes - d) / 10 != res) {
                return 0;
            }

            res = newRes;

            x /= 10;
        }

        return sign * res;
    }
}
