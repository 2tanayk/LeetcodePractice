package binarytree;

import java.util.*;

public class PathSum {
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

        int targetSum = sc.nextInt();

        System.out.println(pathSum(root, targetSum));
    }

    public static boolean pathSum(TreeNode root, int targetSum) {

        return solve(root, 0, targetSum);
    }

    private static boolean solve(TreeNode root, int sum, int target) {
        if (root == null) {
            return false;
        }

        sum += root.val;

        if (root.left == null && root.right == null) {
            return sum == target;
        }

        return solve(root.left, sum, target) || solve(root.right, sum, target);
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
