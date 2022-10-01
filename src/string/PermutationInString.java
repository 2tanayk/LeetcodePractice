package string;

import java.util.*;

public class PermutationInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        HashMap<Character, Integer> hm = new HashMap<>();
        HashSet<Character> hs = new HashSet<>();

        for (int i = 0; i < m; i++) {
            char c = s1.charAt(i);
            hm.put(c, hm.getOrDefault(c, 0) + 1);
            hs.add(c);
        }

        int i = 0, j = i;

        while (j < n) {
            char c1 = s2.charAt(i);
            char c2 = s2.charAt(j);

            if (i == j && !hs.contains(c1)) {
                i++;
                j++;
            } else if (hm.containsKey(c2) && hm.get(c2) > 0) {
                hm.put(c2, hm.get(c2) - 1);
                if (hm.get(c2) == 0) {
                    hm.remove(c2);
                }
                j++;
            } else {
                hm.put(c1, hm.getOrDefault(c1, 0) + 1);
                i++;
            }

            if (hm.size() == 0) {
                return true;
            }
        }

        return false;
    }
}
