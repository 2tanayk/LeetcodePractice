package linkedlist;

import java.util.*;

public class MergeTwoSortedLists {
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

        ListNode head1 = new ListNode(sc.nextInt());
        ListNode cur = head1;

        while (true) {
            int val = sc.nextInt();
            if (val == -1) {
                break;
            }
            cur.next = new ListNode(val);
            cur = cur.next;
        }

        ListNode head2 = new ListNode(sc.nextInt());
        cur = head2;

        while (true) {
            int val = sc.nextInt();
            if (val == -1) {
                break;
            }
            cur.next = new ListNode(val);
            cur = cur.next;
        }

        mergeTwoLists(head1, head2);
    }

    public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode head = new ListNode(-1), temp = head;


        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                head.next = new ListNode(head1.val);
                head1 = head1.next;
            } else {
                head.next = new ListNode(head2.val);
                head2 = head2.next;
            }

            head = head.next;
        }

        while (head1 != null) {
            head.next = new ListNode(head1.val);
            head1 = head1.next;
            head = head.next;
        }

        while (head2 != null) {
            head.next = new ListNode(head2.val);
            head2 = head2.next;
            head = head.next;
        }

        temp = temp.next;
        return temp;
    }
}
