package heap;

import java.util.*;

public class FindMedianFromDataStream {
    static class MedianFinder {
        PriorityQueue<Integer> small;
        PriorityQueue<Integer> large;
        boolean isEven;

        public MedianFinder() {
            small = new PriorityQueue<>(Collections.reverseOrder());
            large = new PriorityQueue<>();
            isEven = true;
        }

        public void addNum(int num) {
            if (isEven) {
                large.add(num);
                small.add(large.poll());
            } else {
                small.add(num);
                large.add(small.poll());
            }

            isEven = !isEven;
        }

        public double findMedian() {
            if (isEven) {
                return (small.peek() + large.peek()) / 2.0;
            }

            return small.peek();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MedianFinder obj = new MedianFinder();

        int num = sc.nextInt();

        obj.addNum(num);

        double param_2 = obj.findMedian();

        System.out.println(param_2);
    }
}
