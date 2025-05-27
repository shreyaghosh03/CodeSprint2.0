class Node {
    int color; 
    Node next;

    Node(int color) {
        this.color = color;
        this.next = null;
    }
}

public class LogisticsCoordinator {
    public static Node sortPackages(Node head) {
        Node redHead = new Node(0);
        Node blueHead = new Node(0);
        Node greenHead = new Node(0);

        Node red = redHead, blue = blueHead, green = greenHead;
        while (head != null) {
            switch (head.color) {
                case 0:
                    red.next = head;
                    red = red.next;
                    break;
                case 1:
                    blue.next = head;
                    blue = blue.next;
                    break;
                default:
                    green.next = head;
                    green = green.next;
                    break;
            }
            head = head.next;
        }
        red.next = blueHead.next; 
        blue.next = greenHead.next; 
        green.next = null; 

        return redHead.next; 
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.color + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(0);
        head.next.next = new Node(1);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(0);
        head.next.next.next.next.next = new Node(1);
        
        System.out.println("Original List:");
        printList(head);

        head = sortPackages(head);

        System.out.println("Sorted List:");
        printList(head);
    }
}