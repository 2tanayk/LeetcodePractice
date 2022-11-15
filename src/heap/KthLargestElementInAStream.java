package heap;

import java.util.*;

public class KthLargestElementInAStream {
    static class KthLargest {
        PriorityQueue<Integer> pq;
        int k;

        public KthLargest(int k, int[] nums) {
            pq = new PriorityQueue<>();
            this.k = k;

            for (int num : nums) {
                if (pq.size() < k) {
                    pq.add(num);
                } else if (num > pq.peek()) {
                    pq.poll();
                    pq.add(num);
                }
            }
        }

        public int add(int val) {
            if (pq.isEmpty() || pq.size() < k) {
                pq.add(val);
            } else if (val > pq.peek()) {
                pq.poll();
                pq.add(val);
            }

            return pq.peek();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        KthLargest obj = new KthLargest(k, nums);
        int val = sc.nextInt();
        int param_1 = obj.add(val);
    }
}
