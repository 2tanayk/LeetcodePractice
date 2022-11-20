package bst;

import java.util.*;

public class ClosestNodesQueriesInABinarySearchTree {
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

        int n = sc.nextInt();

        List<Integer> queries = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            queries.add(sc.nextInt());
        }

        System.out.println(closestNodes(root, queries));
    }

    public static List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> in = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        inorder(root, in);


        for (int q : queries) {
            int l = 0, r = in.size() - 1;
            int min = -1;
            int max = -1;
            while (l <= r) {
                int mid = (l + r) / 2;

                if (in.get(mid) == q) {
                    min = in.get(mid);
                    max = in.get(mid);
                    break;
                } else {
                    if (in.get(mid) > q && (max == -1 || Math.abs(q - max) > Math.abs(q - in.get(mid)))) {
                        max = in.get(mid);
                    } else if (in.get(mid) < q && (min == -1 || Math.abs(q - min) > Math.abs(q - in.get(mid)))) {
                        min = in.get(mid);
                    }
                }

                if (in.get(mid) > q) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            List<Integer> tmp = new ArrayList<>();
            tmp.add(min);
            tmp.add(max);
            ans.add(tmp);
        }

        return ans;
    }

    private static void inorder(TreeNode root, List<Integer> a) {
        if (root == null) {
            return;
        }

        inorder(root.left, a);
        a.add(root.val);
        inorder(root.right, a);
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
