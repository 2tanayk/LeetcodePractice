package string;

import java.util.*;

public class ValidPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        int len = s.length();

        if (len == 0) {
            return true;
        }

        int i = 0, j = len - 1;

        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }

            if (i >= j) {
                break;
            }
            char st = Character.toLowerCase(s.charAt(i));

            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if (i >= j) {
                break;
            }
            char en = Character.toLowerCase(s.charAt(j));

            if (st != en) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
