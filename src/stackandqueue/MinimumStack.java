package stackandqueue;

import java.util.*;

public class MinimumStack {
    static class MinStack {
        class Node {
            int data;
            Node next, prev;
            int min;

            Node(int data, int min) {
                this.data = data;
                this.min = min;
            }
        }

        Node top;

        public MinStack() {
        }

        public void push(int val) {
            int min = top == null ? Integer.MAX_VALUE : top.min;

            min = Math.min(min, val);

            Node node = new Node(val, min);

            if (top == null) {
                top = node;
            } else {
                top.next = node;
                node.prev = top;
                top = top.next;
            }
        }

        public void pop() {
            Node temp = top;
            top = top.prev;
            temp.prev = null;
            if (top != null) {
                top.next = null;
            }
        }

        public int top() {
            return top.data;
        }

        public int getMin() {
            return top.min;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int val = sc.nextInt();

        MinStack obj = new MinStack();
        obj.push(val);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
    }
}
