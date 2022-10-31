package linkedlist;

import java.util.*;

public class ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ListNode head = new ListNode(sc.nextInt());
        ListNode cur = head;

        while (true) {
            int val = sc.nextInt();
            if (val == -1) {
                break;
            }
            cur.next = new ListNode(val);
            cur = cur.next;
        }

        reverseList(head);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode cur = head, next = cur, prev = null;

        while (cur != null) {
            next = next.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
