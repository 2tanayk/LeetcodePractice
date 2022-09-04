package array;

import java.util.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(longestConsecutive(arr));
    }

    public static int longestConsecutive(int[] arr) {
        int n = arr.length;

        if (n == 0) {
            return 0;
        }

        HashSet<Integer> hs = new HashSet<>();

        for (int e : arr) {
            hs.add(e);
        }

        int maxCt = 1;

        for (Integer e : arr) {
            if (hs.contains(e)) {
                int ct = 1;
                hs.remove(e);
                int prev = e - 1;

                while (hs.contains(prev)) {
                    hs.remove(prev);
                    ct++;
                    prev--;
                }

                int next = e + 1;

                while (hs.contains(next)) {
                    hs.remove(next);
                    ct++;
                    next++;
                }

                maxCt = Math.max(maxCt, ct);
            }
        }

        return maxCt;
    }
}
