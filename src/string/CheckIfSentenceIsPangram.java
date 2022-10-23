package string;

import java.util.*;

public class CheckIfSentenceIsPangram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(checkIfPangram(s));
    }

    public static boolean checkIfPangram(String s) {
        HashSet<Character> hs = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            hs.add(s.charAt(i));

            if (hs.size() == 26) {
                return true;
            }
        }

        return false;
    }
}
