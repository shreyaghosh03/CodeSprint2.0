public class MergeSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head; 
        ListNode current; 
        if (list1.val <= list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        current = head; 
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next; 
        }
        if (list1 != null) {
            current.next = list1;
        } else if (list2 != null) {
            current.next = list2;
        }

        return head;
    }
    public static void main(String[] args) {
        MergeSortedLists merger = new MergeSortedLists();
        ListNode list1_ex1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2_ex1 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode mergedList_ex1 = merger.mergeTwoLists(list1_ex1, list2_ex1);
        System.out.print("Merged List: ");
        printList(mergedList_ex1); 

    }
    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("(empty list)");
            return;
        }
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}