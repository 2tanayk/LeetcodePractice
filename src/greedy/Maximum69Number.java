package greedy;

import java.util.*;

public class Maximum69Number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        System.out.println(maximum69Number(num));
    }

    public static int maximum69Number(int num) {
        StringBuilder s = new StringBuilder(num + "");

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '6') {
                s.setCharAt(i, '9');
                break;
            }
        }

        return Integer.parseInt(s.toString());
    }
}
