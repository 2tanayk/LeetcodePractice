package array;

import java.util.*;

public class ValidAnagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String t = sc.nextLine();

        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int len = s.length();

        int[] fArr = new int[26];

        for (int i = 0; i < len; i++) {
            fArr[s.charAt(i) - 'a']++;
            fArr[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (fArr[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
