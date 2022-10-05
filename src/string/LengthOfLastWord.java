package string;

import java.util.*;

public class LengthOfLastWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        s = s.trim();
        return s.trim().substring(s.lastIndexOf(" ") + 1).length();
    }
}
