package string;

import java.util.*;

public class DetermineIfTwoStringsAreClose {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        System.out.println(closeStrings(s1, s2));
    }

    public static boolean closeStrings(String w1, String w2) {
        int len1 = w1.length();
        int len2 = w2.length();

        if (len1 != len2) {
            return false;
        }

        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();

        for (int i = 0; i < len1; i++) {
            char c1 = w1.charAt(i);
            char c2 = w2.charAt(i);

            hm1.put(c1, hm1.getOrDefault(c1, 0) + 1);
            hm2.put(c2, hm2.getOrDefault(c2, 0) + 1);
        }

        if (hm1.size() != hm2.size()) {
            return false;
        }

        HashMap<Integer, Integer> f = new HashMap<>();

        for (char key : hm1.keySet()) {
            if (!hm2.containsKey(key)) {
                return false;
            }

            int val = hm1.get(key);

            f.put(val, f.getOrDefault(val, 0) + 1);
        }


        for (char key : hm2.keySet()) {
            int val = hm2.get(key);

            if (!f.containsKey(val)) {
                return false;
            }

            int ct = f.get(val);

            if (ct == 1) {
                f.remove(val);
            } else {
                f.put(val, ct - 1);
            }
        }

        return true;
    }
}
