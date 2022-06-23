package divideandconquer;

import java.util.*;

public class SortedLinkedListToBalancedBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

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

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int headData = sc.nextInt();
        ListNode head = new ListNode(headData, null);
        createLinkedList(head);

        sortedListToBST(head);
    }

    public static TreeNode sortedListToBST(ListNode head) {
        ListNode cur = head;

        int ct = 0;

        while (cur != null) {
            cur = cur.next;
            ct++;
        }

        return llToBalancedBST(head, 0, ct - 1);
    }

    public static TreeNode llToBalancedBST(ListNode node, int l, int h) {
        if (l > h) {
            return null;
        }

        int mid = (l + h) / 2;

        int ct = mid;
        ListNode cur = node;

        while (ct-- > 0) {
            cur = cur.next;
        }

        TreeNode tNode = new TreeNode(cur.val);

        if (l == h) {
            return tNode;
        }

        tNode.left = llToBalancedBST(node, l, mid - 1);
        tNode.right = llToBalancedBST(node, mid + 1, h);

        return tNode;
    }

    private static void createLinkedList(ListNode cur) {
        while (true) {
            System.out.println("Enter data for the next node:");
            int curData = sc.nextInt();
            if (curData == -1) {
                break;
            }
            cur.next = new ListNode(curData, null);
            cur = cur.next;
        }
    }
}
