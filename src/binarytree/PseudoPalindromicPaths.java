package binarytree;

import java.util.*;

public class PseudoPalindromicPaths {
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

        System.out.println(pseudoPalindromicPaths(root));
    }

    static int ct;

    public static int pseudoPalindromicPaths(TreeNode root) {
        ct = 0;
        boolean[] chk = new boolean[10];

        count(root, chk);

        return ct;
    }

    private static void count(TreeNode root, boolean[] chk) {
        if (root == null) {
            return;
        }

        chk[root.val] = !chk[root.val];

        if (root.left == null && root.right == null) {
            int ctO = 0;

            for (int i = 0; i < 10; i++) {
                if (chk[i]) {
                    ctO++;
                }

                if (ctO >= 2) {
                    break;
                }
            }

            if (ctO <= 1) {
                ct++;
            }
        }

        count(root.left, chk);
        count(root.right, chk);

        chk[root.val] = !chk[root.val];
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
