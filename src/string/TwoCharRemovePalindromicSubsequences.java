package string;

import java.util.*;

public class TwoCharRemovePalindromicSubsequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(removePalindromeSub(s));
    }

    private static int removePalindromeSub(String s) {
        StringBuilder sb = new StringBuilder(s);

        if (sb.reverse().toString().equals(s)) {
            return 1;
        }

        return 2;
    }
}
