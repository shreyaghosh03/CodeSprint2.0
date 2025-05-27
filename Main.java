class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode sortListByActualValue(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head;
        ListNode current = head.next;

        while (current != null) {
            if (current.val < 0) {
                ListNode tempNext = current.next;
                prev.next = tempNext;
                current.next = head;
                head = current;
                current = tempNext;
            } else {
                prev = current;
                current = current.next;
            }
        }
        return head;
    }
}

public class Main {
    public static void main(String[] args) {
        
        ListNode head = new ListNode(1);
        head.next = new ListNode(-2);
        head.next.next = new ListNode(-3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(-5);

        Solution solution = new Solution();

        head = solution.sortListByActualValue(head);

        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println(); 
    }
}