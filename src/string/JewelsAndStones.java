package string;

import java.util.*;

public class JewelsAndStones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String jewels = sc.nextLine();
        String stones = sc.nextLine();

        System.out.println(numJewelsInStones(jewels, stones));
    }

    public static int numJewelsInStones(String jewels, String stones) {
        int m = jewels.length();
        int n = stones.length();

        if (m == 0 || n == 0) {
            return 0;
        }

        HashSet<Character> hs = new HashSet<>();

        for (int i = 0; i < m; i++) {
            hs.add(jewels.charAt(i));
        }

        int ct = 0;

        for (int i = 0; i < n; i++) {
            if (hs.contains(stones.charAt(i))) {
                ct++;
            }
        }

        return ct;
    }
}
