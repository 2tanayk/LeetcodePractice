package binarytree;

import java.util.*;

public class VerticalOrderTraversal {
    public static final Scanner sc = new Scanner(System.in);

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = createBinaryTree();

        System.out.println(verticalTraversal(root));
    }

    static int min, max;

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        findMinMax(root, 0);

        int c = max - min + 1;
        int r = findHeight(root);

        ArrayList<ArrayList<ArrayList<Integer>>> m = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            m.add(new ArrayList<>());
            for (int j = 0; j < c; j++) {
                m.get(i).add(new ArrayList<>());
            }
        }


        findVerticalOrderTraversal(root, 0, 0, m);

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (m.get(i).get(j).size() <= 1) {
                    continue;
                }
                Collections.sort(m.get(i).get(j));
            }
        }

        for (int i = 0; i < c; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < r; j++) {
                temp.addAll(m.get(j).get(i));
            }
            ans.add(temp);
        }

        return ans;
    }

    private static void findVerticalOrderTraversal(TreeNode root, int i, int j, ArrayList<ArrayList<ArrayList<Integer>>> m) {
        if (root == null) {
            return;
        }

        m.get(i).get(j - min).add(root.val);

        findVerticalOrderTraversal(root.left, i + 1, j - 1, m);
        findVerticalOrderTraversal(root.right, i + 1, j + 1, m);
    }

    private static void findMinMax(TreeNode root, int i) {
        if (root == null) {
            return;
        }

        min = Math.min(min, i);
        max = Math.max(max, i);

        findMinMax(root.left, i - 1);
        findMinMax(root.right, i + 1);
    }

    private static int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
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
