package linkedlist;

import java.util.*;

public class ReverseLinkedList2 {
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

        int left = sc.nextInt();
        int right = sc.nextInt();

        System.out.println(reverseBetween(head, left, right));
    }

    public static ListNode reverseBetween(ListNode head, int l, int r) {
        if (l == r) {
            return head;
        }

        ListNode dummy = new ListNode(501);
        dummy.next = head;
        head = dummy;

        ListNode p1 = head.next;

        int i = 1;

        while (i < l - 1) {
            p1 = p1.next;
            i++;
        }

        ListNode leftPrev;

        if (l == 1) {
            leftPrev = head;
        } else {
            leftPrev = p1;
        }

        if (l != 1) {
            p1 = p1.next;
        }


        ListNode prev = p1, leftNode = p1;
        p1 = p1.next;
        i = l + 1;

        while (i <= r) {
            ListNode nxt = p1.next;
            p1.next = prev;
            prev = p1;
            p1 = nxt;

            i++;
        }


        leftNode.next = p1;
        leftPrev.next = prev;

        return head.next;
    }
}
