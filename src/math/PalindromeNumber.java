package math;

import java.util.*;

public class PalindromeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(isPalindrome(n));
    }

    private static boolean isPalindrome(int n) {
        if (n == 0) {
            return true;
        }

        if (n < 0 || n % 10 == 0) {
            return false;
        }

        int rev = 0;

        while (n > rev) {
            rev = rev * 10 + n % 10;
            n = n / 10;
        }

        return n == rev || n == rev / 10;
    }
}
