import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class CompleteBinaryTreeCounter {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getLeftmostHeight(root.left);
        int rightHeight = getLeftmostHeight(root.right);
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) + countNodes(root.right);
        } else { 
            return (1 << rightHeight) + countNodes(root.left);
        }
    }
    private int getLeftmostHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left; 
        }
        return height;
    }
    public TreeNode buildTree(Integer[] nodes) {
        if (nodes == null || nodes.length == 0 || nodes[0] == null) {
            return null;
        }
        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode current = queue.poll();

            if (nodes[i] != null) {
                current.left = new TreeNode(nodes[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < nodes.length && nodes[i] != null) {
                current.right = new TreeNode(nodes[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CompleteBinaryTreeCounter counter = new CompleteBinaryTreeCounter();
        String inputLine = scanner.nextLine();
        scanner.close();
        String[] nodeStrings = inputLine.split(",");
        Integer[] nodes = new Integer[nodeStrings.length];
        for (int i = 0; i < nodeStrings.length; i++) {
            String trimmed = nodeStrings[i].trim();
            if (trimmed.equalsIgnoreCase("null")) {
                nodes[i] = null;
            } else {
                try {
                    nodes[i] = Integer.parseInt(trimmed);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input: '" + trimmed + "'. Please enter valid integers or 'null'.");
                    return; 
                }
            }
        }
        TreeNode root = counter.buildTree(nodes);
        int nodeCount = counter.countNodes(root);
        System.out.println("The total number of nodes in the tree is: " + nodeCount);
    }
}