package dp;

import java.util.*;

public class BinaryTreeMaxSumPath {
    public static final Scanner sc = new Scanner(System.in);

    static public class TreeNode {
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
        TreeNode root = createBinaryTree();

        System.out.println(maxPathSum(root));
    }

    static int max;

    public static int maxPathSum(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }

        max = Integer.MIN_VALUE;

        solve(root);

        return max;
    }

    private static int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lSum = solve(root.left);
        int rSum = solve(root.right);

        if (lSum < 0) {
            lSum = 0;
        }

        if (rSum < 0) {
            rSum = 0;
        }

        max = Math.max(max, root.val + lSum + rSum);

        return root.val + Math.max(lSum, rSum);
    }

    private static TreeNode createBinaryTree() {
        System.out.println("Enter data:");
        int data = sc.nextInt();

        if (data == -1) return null;

        TreeNode rootNode = new TreeNode(data);

        System.out.println("Enter left value for " + data + ":");
        rootNode.left = createBinaryTree();

        System.out.println("Enter right value for " + data + ":");
        rootNode.right = createBinaryTree();

        return rootNode;
    }
}
