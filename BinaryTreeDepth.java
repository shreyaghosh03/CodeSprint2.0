import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeDepth {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public static TreeNode buildTree(String nodes) {
        if (nodes == null || nodes.isEmpty()) {
            return null;
        }
        String[] nodeValues = nodes.split(" ");
        if (nodeValues.length == 0 || nodeValues[0].equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodeValues[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < nodeValues.length) {
            TreeNode current = queue.poll();
            if (i < nodeValues.length && !nodeValues[i].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(nodeValues[i]));
                queue.offer(current.left);
            }
            i++;
            if (i < nodeValues.length && !nodeValues[i].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(nodeValues[i]));
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine(); 
        TreeNode root = buildTree(inputLine);
        int depth = maxDepth(root);
        System.out.println(depth);
        scanner.close();
    }
}