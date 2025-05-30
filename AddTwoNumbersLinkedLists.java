package codes;
public class AddTwoNumbersLinkedLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0); 
            ListNode current = dummyHead; 
            int carry = 0; 

            while (l1 != null || l2 != null || carry != 0) {
                int x = (l1 != null) ? l1.val : 0; 
                int y = (l2 != null) ? l2.val : 0; 

                int sum = x + y + carry; 
                carry = sum / 10; 
                current.next = new ListNode(sum % 10); 

                current = current.next; 

                if (l1 != null) {
                    l1 = l1.next; 
                }
                if (l2 != null) {
                    l2 = l2.next; 
                }
            }

            return dummyHead.next; 
        }
    }
    public static void main(String[] args) {
        ListNode l1_ex1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2_ex1 = new ListNode(5, new ListNode(6, new ListNode(4)));

        Solution sol = new Solution();
        ListNode result_ex1 = sol.addTwoNumbers(l1_ex1, l2_ex1);

        System.out.print("Example 1 Result: ");
        printList(result_ex1); 
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println(" -> null");
    }
}