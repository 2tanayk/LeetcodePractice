package stackandqueue;

import java.util.*;

public class DailyTemperatures {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] temperatures = new int[n];

        for (int i = 0; i < n; i++) {
            temperatures[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    public static int[] dailyTemperatures(int[] arr) {
        int n = arr.length;

        int[] ans = new int[n];

        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {
                int ix = dq.pollLast();
                ans[ix] = i - ix;
            }

            dq.addLast(i);
        }

        return ans;
    }
}
