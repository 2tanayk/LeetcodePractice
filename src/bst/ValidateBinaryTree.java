package bst;

import java.util.*;

public class ValidateBinaryTree {
    private static final Scanner sc = new Scanner(System.in);
    static long prev;

    static class TreeNode {
        TreeNode left, right;
        int val;

        TreeNode(int data) {
            this.val = data;
        }
    }

    public static void main(String[] args) {
        TreeNode root = createBinaryTree();

        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        prev = Long.MIN_VALUE;


        if (root.val == Long.MIN_VALUE || root.val == Long.MAX_VALUE) {
            return false;
        }

        return inorderCheck(root);
    }

    public static boolean inorderCheck(TreeNode node) {
        if (node == null) {
            return true;
        }

        boolean flag = inorderCheck(node.left);

        if (!flag) {
            return false;
        }


        if (prev >= node.val) {
            return false;
        } else {
            prev = node.val;
        }


        flag = inorderCheck(node.right);

        return flag;
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
