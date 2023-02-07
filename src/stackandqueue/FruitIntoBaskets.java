package stackandqueue;

import java.util.*;

public class FruitIntoBaskets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(totalFruit(arr));
    }

    public static int totalFruit(int[] arr) {
        int n = arr.length;

        Deque<Integer> dq = new LinkedList<>();

        int max = Integer.MIN_VALUE;

        int ct = 0;
        for (int i = 0; i < n; i++) {
            if (dq.size() < 2) {
                ct++;
                max = Math.max(max, ct);
                if (dq.size() == 1 && arr[dq.getLast()] == arr[i]) {
                    continue;
                }
                dq.addLast(i);
            } else {
                if (arr[dq.getFirst()] == arr[i] || arr[dq.getLast()] == arr[i]) {
                    ct++;
                    max = Math.max(max, ct);
                    if (arr[dq.getLast()] != arr[i]) {
                        dq.removeFirst();
                        dq.addLast(i);
                    }
                } else {
                    dq.removeFirst();
                    ct = i - dq.getLast() + 1;
                    dq.addLast(i);
                }
            }
        }

        return max;
    }
}
