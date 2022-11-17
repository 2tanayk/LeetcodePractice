package string;

import java.util.*;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String haystack = sc.nextLine();
        String needle = sc.nextLine();

        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String hs, String ned) {
        int n = hs.length();
        int m = ned.length();

        if (m > n) {
            return -1;
        }

        int[] lcs = computeLCS(ned);

        int i = 0, j = 0;

        while (i < n) {
            char c1 = hs.charAt(i);
            char c2 = ned.charAt(j);

            if (c1 == c2) {
                i++;
                j++;
            } else if (j != 0) {
                j = lcs[j - 1];
            } else {
                i++;
            }

            if (j == m) {
                return i - m;
            }
        }

        return -1;
    }

    private static int[] computeLCS(String pat) {
        int m = pat.length();

        int[] lcs = new int[m];
        int i = 0, j = 0;

        lcs[i++] = 0;

        while (i < m) {
            char cur = pat.charAt(i);
            char prev = pat.charAt(j);

            if (cur == prev) {
                lcs[i++] = ++j;
            } else if (j != 0) {
                j = lcs[j - 1];
            } else {
                lcs[i++] = 0;
            }
        }

        return lcs;
    }
}
