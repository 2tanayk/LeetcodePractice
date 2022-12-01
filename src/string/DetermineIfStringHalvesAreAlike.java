package string;

import java.util.*;

public class DetermineIfStringHalvesAreAlike {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(halvesAreAlike(s));
    }

    public static boolean halvesAreAlike(String s) {
        int len = s.length();

        int i = 0, j = len - 1;

        int ct1 = 0, ct2 = 0;

        while (i < j) {
            char c1 = s.charAt(i++);
            char c2 = s.charAt(j--);

            if (isVowel(c1)) {
                ct1++;
            }

            if (isVowel(c2)) {
                ct2++;
            }

        }

        return ct1 == ct2;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
