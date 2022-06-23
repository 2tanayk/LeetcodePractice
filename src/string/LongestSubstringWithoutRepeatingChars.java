package string;

import java.util.*;

public class LongestSubstringWithoutRepeatingChars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(lengthOfLongestSubstring(s));
    }

    private static int lengthOfLongestSubstring(String s) {
        int max = 0, cLen = 0, start = 0, end = 0;
        HashSet<Character> cSet = new HashSet<>();

        for (int i = 0; i < s.length(); ) {
            char ch = s.charAt(i);

            if (!cSet.contains(ch)) {
                cSet.add(ch);
                cLen++;
                end++;
                i++;
            } else {
                cLen -= 1;
                cSet.remove(s.charAt(start));
                start++;
            }

            if (cLen > max) {
                max = cLen;
            }

        }

        return max;
    }
}
