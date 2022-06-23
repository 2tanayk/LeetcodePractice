package string;

import java.util.*;

public class BuddyString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String goal = sc.nextLine();

        System.out.println(buddyStrings(s, goal));
    }

    private static boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            HashMap<Character, Integer> fMap = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                int freq = fMap.getOrDefault(ch, 0) + 1;
                fMap.put(ch, freq);

                if (freq > 1) {
                    return true;
                }
            }

            return false;
        }

        int len = s.length();
        int ct = 0;
        char[] displaced1 = new char[2];
        char[] displaced2 = new char[2];

        for (int i = 0; i < len; i++) {
            char ch1 = s.charAt(i);
            char ch2 = goal.charAt(i);

            if (ch1 != ch2) {

                if ((ct + 1) > 2) {
                    return false;
                }

                displaced1[ct] = ch1;
                displaced2[ct] = ch2;
                ct++;
            }
        }

        if (ct == 2) {
            return (displaced1[0] == displaced2[1] && displaced1[1] == displaced2[0]);
        }

        return false;
    }
}
