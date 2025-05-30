package codes;
public class RemoveNodesFromDoublyLinkedList {
    public static class Node {
        int val;
        Node prev;
        Node next;

        public Node() {}
        public Node(int val) { this.val = val; }
        public Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
    public static class Solution {
        public Node removeNodes(Node head, int target) {
            if (head == null) {
                return null;
            }
            Node current = head;
            while (current != null) {
                if (current.val == target) {
                    if (current == head) {
                        head = current.next; 
                        if (head != null) {
                            head.prev = null; 
                        }
                        current = head; 
                    }
                    else {
                        if (current.prev != null) {
                            current.prev.next = current.next; 
                        }
                        if (current.next != null) {
                            current.next.prev = current.prev; 
                        }
                        current = current.next;
                    }
                } else {
                    current = current.next;
                }
            }
            return head;
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Example 1:");
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(1);
        Node n5 = new Node(4);

        n1.next = n2; n2.prev = n1;
        n2.next = n3; n3.prev = n2;
        n3.next = n4; n4.prev = n3;
        n4.next = n5; n5.prev = n4;

        Node head1 = sol.removeNodes(n1, 1);
        printList(head1); 
    }
    public static void printList(Node head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" <-> ");
            }
            current = current.next;
        }
        System.out.println(" -> null");
    }
}
