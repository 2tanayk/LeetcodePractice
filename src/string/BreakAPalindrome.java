package string;

import java.util.*;

public class BreakAPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(breakPalindrome(s));
    }

    public static String breakPalindrome(String s) {
        int len = s.length();

        if (len == 1) {
            return "";
        }

        StringBuilder ans = new StringBuilder(s);

        int i = 0;

        while (i < len / 2) {
            char c = s.charAt(i);

            if (c != 'a') {
                ans.setCharAt(i, 'a');
                return ans.toString();
            }

            i++;
        }

        ans.setCharAt(len - 1, (char) (s.charAt(len - 1) + 1));

        return ans.toString();
    }
}
