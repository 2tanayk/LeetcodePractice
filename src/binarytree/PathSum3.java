package binarytree;

import java.util.*;

public class PathSum3 {
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

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();

        solve(root, 0, new ArrayList<>(), ans, targetSum);

        return ans;
    }

    private static void solve(TreeNode node, int sum, List<Integer> tmp, List<List<Integer>> ans, int target) {
        if (node == null) {
            return;
        }

        sum += node.val;
        tmp.add(node.val);

        if (node.left == null && node.right == null) {
            if (sum == target) {
                ans.add(new ArrayList<>(tmp));
            }
        }

        solve(node.left, sum, tmp, ans, target);
        solve(node.right, sum, tmp, ans, target);

        tmp.remove(tmp.size() - 1);
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
