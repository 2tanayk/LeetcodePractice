package dp;

import java.util.*;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(countSubstrings(s));
    }

    public static int countSubstrings(String s) {
        int len = s.length();

        int ct = 0;

        for (int i = 0; i < len; i++) {
            int l = i, r = i;

            ct += countPalindromes(s, l, r);

            l = i;
            r = i + 1;

            ct += countPalindromes(s, l, r);
        }

        return ct;
    }

    private static int countPalindromes(String s, int l, int r) {
        int len = s.length();
        int ct = 0;

        while (l >= 0 && r < len && s.charAt(l--) == s.charAt(r++)) {
            ct++;
        }

        return ct;
    }
}
