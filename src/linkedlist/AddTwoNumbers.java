package linkedlist;

import java.util.*;

public class AddTwoNumbers {
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

        System.out.println(addTwoNumbers(head1, head2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = len(l1);
        int len2 = len(l2);

        if (len1 < len2) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;

            int tmp = len1;
            len1 = len2;
            len2 = tmp;
        }

        sum(l1, l2, len1, len2, 0);

        return l1;
    }

    public static void sum(ListNode cur1, ListNode cur2, int l1, int l2, int carry) {
        int sum;

        if (cur2 != null) {
            sum = cur1.val + cur2.val + carry;
        } else {
            sum = cur1.val + carry;
        }

        cur1.val = sum % 10;

        if (cur1.next == null) {
            if (sum / 10 > 0) {
                cur1.next = new ListNode(sum / 10);
            }
            return;
        }

        if (cur2 == null) {
            sum(cur1.next, null, l1, l2, sum / 10);
        } else {
            sum(cur1.next, cur2.next, l1, l2, sum / 10);
        }
    }


    public static int len(ListNode cur) {
        int ct = 0;

        while (cur != null) {
            ct++;
            cur = cur.next;
        }

        return ct;
    }
}
