package math;

import java.util.*;

public class NumbersWithSameConsecutiveDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(Arrays.toString(numsSameConsecDiff(n, k)));
    }

    static ArrayList<Integer> list;

    public static int[] numsSameConsecDiff(int n, int k) {
        list = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            findNums(i, 0, "", k, n);
        }

        int[] ans = new int[list.size()];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }

    private static void findNums(int d, int i, String s, int k, int n) {
        if (d < 0 || d > 9) {
            return;
        }

        s = s + d;

        if (i == n - 1) {
            list.add(Integer.parseInt(s));
            return;
        }

        findNums(d + k, i + 1, s, k, n);

        if (k == 0) {
            return;
        }

        findNums(d - k, i + 1, s, k, n);
    }
}
