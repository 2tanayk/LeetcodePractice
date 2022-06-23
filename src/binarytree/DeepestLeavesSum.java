package binarytree;

import java.util.*;

public class DeepestLeavesSum {
    private static final Scanner sc = new Scanner(System.in);

    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = createBinaryTree();
        System.out.println(deepestLeavesSum(root));
    }

    public static int deepestLeavesSum(Node root) {
        int height = findHeight(root) - 1;

        return findDeepSum(root, 0, height);
    }

    private static int findDeepSum(Node root, int depth, int height) {
        if (root == null) {
            return 0;
        }

        if (depth == height) {
            return root.data;
        }

        return findDeepSum(root.left, depth + 1, height) + findDeepSum(root.right, depth + 1, height);
    }


    private static int findHeight(Node root) {
        if (root == null) {
            return 0;
        }

        return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
    }

    private static Node createBinaryTree() {
        System.out.println("Enter data:");
        int data = sc.nextInt();

        if (data == -1) return null;

        Node rootNode = new Node(data);

        System.out.println("Enter left value for " + data + ":");
        rootNode.left = createBinaryTree();

        System.out.println("Enter right value for " + data + ":");
        rootNode.right = createBinaryTree();

        return rootNode;
    }
}
