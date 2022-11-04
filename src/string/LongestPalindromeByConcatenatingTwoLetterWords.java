package string;

import java.util.*;

public class LongestPalindromeByConcatenatingTwoLetterWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = sc.nextLine();
        }

        System.out.println(longestPalindrome(words));
    }

    public static int longestPalindrome(String[] words) {
        HashMap<String, Integer> hm = new HashMap<>();

        for (String word : words) {
            hm.put(word, hm.getOrDefault(word, 0) + 1);
        }

        int ct = 0;

        for (String key : hm.keySet()) {
            int fk = hm.get(key);

            String rev = new StringBuilder(key).reverse().toString();

            if (key.equals(rev)) {
                ct += 4 * (fk / 2);
                hm.put(key, fk % 2);
            } else if (hm.containsKey(rev)) {
                int fr = hm.get(rev);

                int c = Math.min(fk, fr);
                ct += 4 * c;

                hm.put(key, fk - c);
                hm.put(rev, fr - c);
            }
        }

        for (String key : hm.keySet()) {
            int f = hm.get(key);
            String rev = new StringBuilder(key).reverse().toString();

            if (key.equals(rev) && f > 0) {
                ct += 2;
                break;
            }
        }

        return ct;
    }
}
