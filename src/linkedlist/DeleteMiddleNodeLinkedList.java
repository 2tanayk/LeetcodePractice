package linkedlist;

import java.util.*;

public class DeleteMiddleNodeLinkedList {
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

        deleteMiddle(head);
    }

    public static ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }

        ListNode slow = head, fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}
