package string;

import java.util.*;

public class OrderlyQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int k = sc.nextInt();

        System.out.println(orderlyQueue(s, k));
    }

    public static String orderlyQueue(String s, int k) {
        if (k > 1) {
            char[] tmp = s.toCharArray();
            Arrays.sort(tmp);

            return String.valueOf(tmp);
        }

        int len = s.length();

        String min = s;

        for (int i = 1; i < len; i++) {
            String tmp = s.substring(i) + s.substring(0, i);

            if (min.compareTo(tmp) > 0) {
                min = tmp;
            }
        }

        return min;
    }
}
