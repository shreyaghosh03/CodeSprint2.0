import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class SortedArrayToBalancedBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildBST(nums, 0, nums.length - 1);
    }
    private TreeNode buildBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildBST(nums, start, mid - 1);
        node.right = buildBST(nums, mid + 1, end);
        return node;
    }
    public List<Integer> getLevelOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result; 
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); 
        boolean encounteredNonNull = false;
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll(); 

            if (current == null) {
                result.add(null); 
            } else {
                result.add(current.val); 
                encounteredNonNull = true; 
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }
        while (result.size() > 0 && result.get(result.size() - 1) == null) {
            result.remove(result.size() - 1);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SortedArrayToBalancedBST converter = new SortedArrayToBalancedBST();
        String inputLine = scanner.nextLine(); 
        scanner.close(); 
        String[] numStrings = inputLine.split(","); 
        int[] nums;
        if (numStrings.length == 1 && numStrings[0].trim().isEmpty()) {
            nums = new int[0]; 
        } else {
            nums = new int[numStrings.length]; 
            try {
                for (int i = 0; i < numStrings.length; i++) {
                    nums[i] = Integer.parseInt(numStrings[i].trim()); 
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: Invalid input format. Please enter comma-separated integers.");
                return; 
            }
        }
        TreeNode bstRoot = converter.sortedArrayToBST(nums);
        List<Integer> levelOrderResult = converter.getLevelOrderTraversal(bstRoot);
        System.out.println("Output (Level-order traversal of BST): " + levelOrderResult);
    }
}