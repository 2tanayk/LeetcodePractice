package linkedlist;

import java.util.*;

public class ReorderList {
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

        reorderList(head);
    }

    public static void reorderList(ListNode head) {
        ArrayList<ListNode> a = new ArrayList<>();

        while (head != null) {
            a.add(head);
            head = head.next;
        }


        int n = a.size();

        int i = 0;

        ListNode temp = new ListNode(0);
        head = temp;

        while (i < n / 2) {
            temp.next = a.get(i);
            temp = temp.next;
            temp.next = a.get(n - i - 1);
            temp = temp.next;
            i++;
        }

        if (n % 2 != 0) {
            temp.next = a.get(n / 2);
            temp = temp.next;
        }

        temp.next = null;
    }
}
