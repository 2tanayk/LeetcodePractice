package string;

import java.util.*;

public class LongPressedName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        String typed = sc.nextLine();

        System.out.println(isLongPressedName(name, typed));
    }

    private static boolean isLongPressedName(String name, String typed) {
        if (name.equals(typed)) {
            return true;
        }

        if (name.charAt(0) != typed.charAt(0)) {
            return false;
        }

        int tLen = typed.length();
        int len = name.length();


        int i = 0, j = 0;

        while (i < len && j < tLen) {
            char ch1 = name.charAt(i);
            int ct1 = 1;
            i++;

            while (i < len && name.charAt(i) == ch1) {
                ct1++;
                i++;
            }

            char ch2 = typed.charAt(j);
            int ct2 = 1;
            j++;

            while (j < tLen && typed.charAt(j) == ch2) {
                ct2++;
                j++;
            }

            if (ch1 != ch2) {
                return false;
            }

            if (ct1 > ct2) {
                return false;
            }
        }

        return j >= tLen && i >= len;
    }
}
