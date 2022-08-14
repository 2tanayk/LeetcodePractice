package dp;

import java.util.*;

public class DiameterOfBinaryTree {
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

        System.out.println(diameterOfBinaryTree(root));
    }

    static int d;

    public static int diameterOfBinaryTree(TreeNode root) {
        d = Integer.MIN_VALUE;

        solve(root);

        return d - 1;
    }

    private static int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lHeight = solve(root.left);
        int rHeight = solve(root.right);

        d = Math.max(d, 1 + lHeight + rHeight);

        return 1 + Math.max(lHeight, rHeight);
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
