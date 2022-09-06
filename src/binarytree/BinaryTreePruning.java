package binarytree;

import java.util.*;

public class BinaryTreePruning {
    public static final Scanner sc = new Scanner(System.in);

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = createBinaryTree();

        System.out.println(pruneTree(root));
    }

    public static TreeNode pruneTree(TreeNode root) {
        if (!prune(root)) {
            return null;
        }

        return root;
    }

    private static boolean prune(TreeNode root) {
        if (root == null) {
            return false;
        }

        boolean left = prune(root.left);
        if (!left) {
            root.left = null;
        }
        boolean right = prune(root.right);
        if (!right) {
            root.right = null;
        }

        return left || right || root.val == 1;
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
