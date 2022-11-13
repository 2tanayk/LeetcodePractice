package binarytree;

import java.util.*;

public class MinimumNumberOfOperationsToSortABinaryTreeByLevel {
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

        System.out.println(minimumOperations(root));
    }

    static class Pair {
        int no, pos;

        Pair(int no, int pos) {
            this.no = no;
            this.pos = pos;
        }
    }

    public static int minimumOperations(TreeNode root) {
        int ans = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);


        while (!q.isEmpty()) {
            int ct = q.size();
            List<Pair> a = new ArrayList<>();
            int i = 0;
            while (ct > 0) {
                TreeNode cur = q.poll();
                if (cur.left != null) {
                    q.add(cur.left);
                }

                if (cur.right != null) {
                    q.add(cur.right);
                }

                a.add(new Pair(cur.val, i++));
                ct--;
            }

            ans += minOps(a);
        }

        return ans;
    }

    private static int minOps(List<Pair> a) {
        int ct = 0;
        Collections.sort(a, (p1, p2) -> p1.no - p2.no);

        for (int i = 0; i < a.size(); ) {
            Pair cur = a.get(i);
            if (i == cur.pos) {
                i++;
            } else {
                ct++;
                swap(a, i, cur.pos);
            }
        }

        return ct;
    }

    private static void swap(List<Pair> a, int i, int j) {
        Pair tmp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, tmp);
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
