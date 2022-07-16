package stackandqueue;

import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        int k = sc.nextInt();

        System.out.println(Arrays.toString(maxSlidingWindow(arr, k)));
    }

    public static int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;

        int[] ans = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        int j = 0;

        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.getFirst() == i - k) {
                dq.removeFirst();
            }

            while (!dq.isEmpty() && arr[dq.getLast()] < arr[i]) {
                dq.removeLast();
            }

            dq.addLast(i);

            if (i >= k - 1) {
                ans[j++] = arr[dq.getFirst()];
            }
        }

        return ans;
    }
}
