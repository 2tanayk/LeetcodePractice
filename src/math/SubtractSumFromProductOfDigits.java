package math;

import java.util.*;

public class SubtractSumFromProductOfDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(subtractProductAndSum(n));
    }

    public static int subtractProductAndSum(int n) {
        int sum = 0, prod = 1;

        while (n > 0) {
            int d = n % 10;

            prod *= d;
            sum += d;

            n /= 10;
        }

        return prod - sum;
    }
}
