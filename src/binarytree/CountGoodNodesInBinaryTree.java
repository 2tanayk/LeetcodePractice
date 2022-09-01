package binarytree;

import java.util.*;

public class CountGoodNodesInBinaryTree {
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

        System.out.println(goodNodes(root));
    }

    static int ct;

    public static int goodNodes(TreeNode root) {
        ct = 0;

        count(root, Integer.MIN_VALUE);

        return ct;
    }

    private static void count(TreeNode root, int max) {
        if (root == null) {
            return;
        }

        if (root.val >= max) {
            ct++;
        }

        count(root.left, Math.max(max, root.val));
        count(root.right, Math.max(max, root.val));
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
