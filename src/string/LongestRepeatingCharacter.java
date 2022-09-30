package string;

import java.util.*;

public class LongestRepeatingCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int k = sc.nextInt();

        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k) {
        int len = s.length();

        HashMap<Character, Integer> hm = new HashMap<>();

        int l = 0, r = l + 1, max = 0, ct = k;

        char c1 = s.charAt(l);

        hm.put(c1, hm.getOrDefault(c1, 0) + 1);

        int tot = 1;

        while (r < len) {
            c1 = s.charAt(l);
            char c2 = s.charAt(r);

            hm.put(c2, hm.getOrDefault(c2, 0) + 1);
            tot++;

            if (c1 == c2) {
                max = Math.max(max, r - l + 1);
            } else if (ct > 0) {
                ct--;
                max = Math.max(max, r - l + 1);
            } else {
                while (l <= r && tot - hm.get(c1) > k) {
                    hm.put(c1, hm.get(c1) - 1);
                    l++;
                    tot--;
                    c1 = s.charAt(l);
                }

                ct = k - (tot - hm.get(c1));
            }

            if (r == len - 1) {
                max = Math.max(max, Math.min(r - l + 1 + ct, len));
            }

            r++;
        }

        return max;
    }
}
