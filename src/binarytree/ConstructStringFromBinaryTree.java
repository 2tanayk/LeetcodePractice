package binarytree;

import java.util.*;

public class ConstructStringFromBinaryTree {
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

        System.out.println(tree2str(root));
    }

    public static String tree2str(TreeNode root) {
        StringBuilder s = new StringBuilder();

        createString(root, s);

        return s.toString();
    }

    private static void createString(TreeNode root, StringBuilder s) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            s.append(root.val);
            return;
        }

        s.append(root.val).append("(");

        createString(root.left, s);

        s.append(")");

        if (root.right == null) {
            return;
        }

        s.append("(");
        createString(root.right, s);
        s.append(")");
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
