package bitmanipulation;

import java.util.*;

public class ConcatenationOfConsecutiveBinaryNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(concatenatedBinary(n));
    }

    public static int concatenatedBinary(int n) {
        long m = (long) Math.pow(10, 9) + 7;

        long ans = 0;

        for (int i = 1; i <= n; i++) {
            int nD = 1 + (int) (Math.log(i) / Math.log(2));
            ans = ((ans << nD) % m + i) % m;
        }

        return (int) ans;
    }
}
