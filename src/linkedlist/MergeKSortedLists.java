package linkedlist;

import java.util.*;

public class MergeKSortedLists {
    private static final Scanner sc = new Scanner(System.in);

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
        int k = sc.nextInt();

        ListNode[] list = new ListNode[k];

        for (int i = 0; i < k; i++) {
            list[i] = createLinkedList();
        }

        System.out.println(mergeKLists(list));
    }

    public static ListNode mergeKLists(ListNode[] l) {
        int k = l.length;

        if (k == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>(k, (n1, n2) -> n1.val - n2.val);

        for (int i = 0; i < k; i++) {
            if (l[i] == null) {
                continue;
            }

            pq.add(l[i]);
        }

        ListNode head = new ListNode(-1), cur = head;

        while (!pq.isEmpty()) {
            ListNode tmp = pq.poll();
            cur.next = tmp;
            cur = cur.next;

            if (tmp.next != null) {
                pq.add(tmp.next);
            }
        }

        cur.next = null;


        return head.next;
    }

    private static ListNode createLinkedList() {
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

        return head;
    }
}
