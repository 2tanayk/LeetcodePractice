package binarytree;

import java.util.*;

public class AddOneRowToTree {
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

        int val = sc.nextInt();
        int depth = sc.nextInt();

        System.out.println(addOneRow(root, val, depth));
    }

    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode temp = root;
            root = new TreeNode(val);
            root.left = temp;

            return root;
        }

        return solve(root, 1, val, depth);
    }

    private static TreeNode solve(TreeNode root, int d, int val, int depth) {
        if (root == null) {
            return null;
        }

        if (d == depth - 1) {
            TreeNode tempL = root.left;
            TreeNode tempR = root.right;

            root.left = new TreeNode(val);
            root.right = new TreeNode(val);

            root.left.left = tempL;
            root.right.right = tempR;
        } else {
            root.left = solve(root.left, d + 1, val, depth);
            root.right = solve(root.right, d + 1, val, depth);
        }

        return root;
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
