package string;

import java.util.*;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        s = s.trim();
        int len = s.length();

        StringBuilder sb = new StringBuilder();

        int i = 0;

        char prev = '$';

        while (i < len) {
            char cur = s.charAt(i++);
            if (cur == prev && cur == ' ') {
                continue;
            } else {
                sb.append(cur);
            }
            prev = cur;
        }

        String[] arr = sb.toString().split(" ");

        sb = new StringBuilder();

        for (i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]).append(" ");
        }

        return sb.toString().substring(0, sb.length() - 1);
    }
}
