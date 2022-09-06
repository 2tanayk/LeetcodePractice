package array;

import java.util.*;

public class EncodeAndDecodeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        List<String> strs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            strs.add(sc.nextLine());
        }

        System.out.println(decode(encode(strs)));
    }

    public static String encode(List<String> strs) {
        StringBuilder enc = new StringBuilder();

        for (String s : strs) {
            int len = s.length();
            enc.append(len).append("$").append(s);
        }

        System.out.println(enc);

        return enc.toString();
    }

    public static List<String> decode(String str) {
        List<String> dec = new ArrayList<>();

        int i = 0;
        while (i < str.length()) {
            StringBuilder sb = new StringBuilder();
            while (str.charAt(i) != '$') {
                sb.append(str.charAt(i));
                i++;
            }
            i++;
            Integer len = Integer.parseInt(sb.toString());
            dec.add(str.substring(i, i + len));
            i += len;
        }

        return dec;
    }
}
