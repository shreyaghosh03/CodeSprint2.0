class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public boolean detectAndRemoveCycle(ListNode head) {
        if (head == null || head.next == null) {
            // No loop possible with 0 or 1 node
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        boolean cycleDetected = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycleDetected = true;
                break;
            }
        }

        if (!cycleDetected) {
            return true;
        }

        slow = head;
        ListNode cycleStart = null;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        cycleStart = slow; 
        ListNode current = cycleStart;
        while (current.next != cycleStart) {
            current = current.next;
        }
        current.next = null; 

        return true; 
    }

    public ListNode createLinkedListWithCycle(int[] arr, int pos) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        ListNode cycleNode = null; 

        if (pos == 1) {
            cycleNode = head;
        }

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
            if (pos == i + 1) {
                cycleNode = current;
            }
        }

        if (pos > 0 && cycleNode != null) {
            current.next = cycleNode; 
        }
        return head;
    }

    public void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        int[] arr1 = {1, 2, 3, 4, 5};
        ListNode head1 = solver.createLinkedListWithCycle(arr1, 0);
        System.out.println("Original List 1 (No Cycle):");
        solver.printLinkedList(head1);
        boolean result1 = solver.detectAndRemoveCycle(head1);
        System.out.println("Cycle Removal Result 1: " + result1);
        System.out.println("List 1 After Removal:");
        solver.printLinkedList(head1);
        System.out.println("--------------------");

    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'splitListToParts'");
    }

    ListNode[] splitListToParts(ListNode head, int k) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String findMissingNumber(int[] nums) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findMissingNumber'");
    }
}