package stackandqueue;

import java.util.*;

public class DesignCircularQueue {
    static class MyCircularQueue {
        int[] q;
        int size;
        int front, rear;

        public MyCircularQueue(int k) {
            size = k;
            q = new int[size];
            front = rear = -1;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }

            if (isEmpty()) {
                ++front;
            }

            rear = ++rear % size;
            System.out.println(front + " " + rear);
            q[rear] = value;

            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }

            if (front == rear) {
                front = -1;
                rear = -1;
                return true;
            }

            front = ++front % size;

            return true;
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            }

            return q[front % size];
        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            }

            return q[rear % size];
        }

        public boolean isEmpty() {
            if (front == -1 && rear == -1) {
                return true;
            }
            return false;
        }

        public boolean isFull() {
            if (front == 0 && rear == size - 1 || front == rear + 1) {
                return true;
            }

            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        MyCircularQueue myCircularQueue = new MyCircularQueue(k);
    }
}
