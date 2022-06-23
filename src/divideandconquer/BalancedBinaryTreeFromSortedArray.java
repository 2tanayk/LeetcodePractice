package divideandconquer;

import java.util.*;

public class BalancedBinaryTreeFromSortedArray {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(sortedArrayToBST(arr));
    }

    public static TreeNode sortedArrayToBST(int[] arr) {
        int n = arr.length;

        return buildBalancedBST(arr, 0, n - 1);
    }

    private static TreeNode buildBalancedBST(int[] arr, int l, int h) {
        if (l > h) {
            return null;
        }

        if (l == h) {
            return new TreeNode(arr[l]);
        }

        int mid = (l + h) / 2;

        TreeNode node = new TreeNode(arr[mid]);

        node.left = buildBalancedBST(arr, l, mid - 1);
        node.right = buildBalancedBST(arr, mid + 1, h);

        return node;
    }
}
