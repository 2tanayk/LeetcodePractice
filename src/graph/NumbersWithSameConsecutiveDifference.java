package graph;

import java.util.*;

public class NumbersWithSameConsecutiveDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(Arrays.toString(numsSameConsecDiff(n, k)));
    }

    public static int[] numsSameConsecDiff(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();

        Queue<String> q = new LinkedList<>();

        for (int i = 1; i <= 9; i++) {
            q.add(i + "");
        }

        while (!q.isEmpty()) {
            String cur = q.poll();

            if (cur.length() == n) {
                list.add(Integer.parseInt(cur));
                continue;
            }

            int last = cur.charAt(cur.length() - 1) - '0';

            if (last + k < 10) {
                q.add(cur + "" + (last + k));
            }

            if (k == 0) {
                continue;
            }

            if (last - k >= 0) {
                q.add(cur + "" + (last - k));
            }
        }

        int[] ans = new int[list.size()];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}
