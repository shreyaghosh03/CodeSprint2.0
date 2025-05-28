class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class SplitLinkedList {

    public ListNode[] splitListToParts(ListNode root, int k) {
        int totalLength = 0;
        ListNode current = root;
        
        while (current != null) {
            totalLength++;
            current = current.next;
        }

        int partSize = totalLength / k;
        int remainder = totalLength % k;

        ListNode[] result = new ListNode[k];

        current = root;
        for (int i = 0; i < k; i++) {
            ListNode head = current;
            int currentPartSize = partSize + (i < remainder ? 1 : 0);

            for (int j = 0; j < currentPartSize - 1; j++) {
                if (current != null) {
                    current = current.next;
                }
            }

            if (current != null) {
                ListNode nextPartHead = current.next;
                current.next = null;
                current = nextPartHead;
            }

            result[i] = head;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        SplitLinkedList splitter = new SplitLinkedList();
        ListNode[] parts = splitter.splitListToParts(head, 3);
        
        for (ListNode part : parts) {
            ListNode current = part;
            while (current != null) {
                System.out.print(current.val + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}