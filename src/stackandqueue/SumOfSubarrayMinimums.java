package stackandqueue;

import java.util.*;

public class SumOfSubarrayMinimums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(sumSubarrayMins(arr));
    }

    public static int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        long m = (int) Math.pow(10, 9) + 7;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> ps = new Stack<>();
        Stack<Integer> ns = new Stack<>();

        for (int i = 0; i < n; i++) {
            left[i] = i + 1;
            right[i] = n - i;
        }

        for (int i = 0; i < n; i++) {
            while (!ps.empty() && arr[ps.peek()] >= arr[i]) {
                ps.pop();
            }

            left[i] = ps.empty() ? i + 1 : i - ps.peek();
            ps.push(i);

            while (!ns.empty() && arr[ns.peek()] >= arr[i]) {
                int top = ns.pop();
                right[top] = i - top;
            }
            ns.push(i);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (sum + (long) arr[i] * left[i] * right[i]) % m;
        }

        return (int) sum;
    }
}
