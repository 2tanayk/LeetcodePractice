package string;

import java.util.*;

public class ReverseWordsInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        int n = s.length();
        StringBuilder ans = new StringBuilder();

        int st = 0;
        int en = s.indexOf(' ');

        while (en != -1) {
            ans.append(new StringBuilder(s.substring(st, en)).reverse().toString());
            ans.append(" ");
            st = en + 1;
            en = s.indexOf(' ', st);
        }

        ans.append(new StringBuilder(s.substring(st)).reverse().toString());

        return ans.toString();
    }
}
