package stackandqueue;

import java.util.*;

public class PushDominoes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(pushDominoes(s));
    }

    public static String pushDominoes(String s) {
        int len = s.length();
        char[] dms = s.toCharArray();

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            if (dms[i] == 'L' || dms[i] == 'R') {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int i = q.poll();

            if (dms[i] == 'L' && i > 0 && dms[i - 1] == '.') {
                dms[i - 1] = 'L';
                q.add(i - 1);
            } else if (dms[i] == 'R' && i + 1 < len && dms[i + 1] == '.') {
                if (i + 2 < len && dms[i + 2] == 'L') {
                    q.poll();
                } else {
                    dms[i + 1] = 'R';
                    q.add(i + 1);
                }
            }
        }

        return String.valueOf(dms);
    }
}
