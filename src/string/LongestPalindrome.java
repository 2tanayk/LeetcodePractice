package string;

import java.util.*;

public class LongestPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(longestPalindrome(s));
    }

    private static int longestPalindrome(String s) {
        int n = s.length();

        if (n == 1) {
            return 1;
        }

        HashMap<Character, Integer> fm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            fm.put(ch, fm.getOrDefault(ch, 0) + 1);
        }

        int ct = 0;

        Iterator<Map.Entry<Character, Integer>> it = fm.entrySet().iterator();
        boolean flag = false;

        while (it.hasNext()) {
            Map.Entry<Character, Integer> e = it.next();
            int value = e.getValue();

            if (value % 2 == 0) {
                ct += value;
            } else {
                ct += (value - 1);
                flag = true;
            }
        }

        return flag ? ct + 1 : ct;
    }
}
