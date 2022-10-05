package string;

import java.util.*;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String t = sc.nextLine();

        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (t.equals("") || n > m) {
            return "";
        }

        HashMap<Character, Integer> tCt = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char c = t.charAt(i);
            tCt.put(c, tCt.getOrDefault(c, 0) + 1);
        }

        int min = Integer.MAX_VALUE, l = -1, r = -1;
        int have = 0, need = tCt.size(), i = 0, j = 0;


        while (j < m) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);

            if (tCt.containsKey(c2)) {
                window.put(c2, window.getOrDefault(c2, 0) + 1);

                if (window.get(c2).intValue() == tCt.get(c2).intValue()) {
                    have++;
                }

                while (have == need) {
                    c1 = s.charAt(i);
                    if (j - i + 1 < min) {
                        min = j - i + 1;
                        l = i;
                        r = j;
                    }

                    if (tCt.containsKey(c1)) {
                        window.put(c1, window.get(c1) - 1);

                        if (window.get(c1).intValue() < tCt.get(c1).intValue()) {
                            have--;
                        }
                    }

                    i++;
                }
            }

            j++;
        }

        return l == -1 ? "" : s.substring(l, r + 1);
    }
}
