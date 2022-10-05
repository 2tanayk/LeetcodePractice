package string;

import java.util.*;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String[] strs = new String[n];

        for (int i = 0; i < n; i++) {
            strs[i] = sc.nextLine();
        }

        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        StringBuilder ans = new StringBuilder("");

        int i = 0;

        outer:
        while (i < strs[0].length()) {
            char c = strs[0].charAt(i);

            for (int j = 1; j < n; j++) {
                String s = strs[j];

                if (i >= s.length() || c != s.charAt(i)) {
                    break outer;
                }
            }

            ans.append(c);
            i++;
        }

        return ans.toString();
    }
}
