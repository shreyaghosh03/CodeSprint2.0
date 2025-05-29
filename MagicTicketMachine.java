class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class MagicTicketMachine {
    public ListNode doubleNumber(ListNode head) {
        if (head == null) {
            return null;
        }
        long number = 0;
        ListNode current = head;
        while (current != null) {
            number = number * 10 + current.val;
            current = current.next;
        }
        long doubledNumber = number * 2;
        if (doubledNumber == 0) {
            return new ListNode(0);
        }
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        while (doubledNumber > 0) {
            stack.push((int) (doubledNumber % 10));
            doubledNumber /= 10;
        }

        ListNode newHead = null;
        ListNode tail = null;

        while (!stack.isEmpty()) {
            ListNode newNode = new ListNode(stack.pop());
            if (newHead == null) {
                newHead = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        return newHead;
    }
    public ListNode doubleNumberRobust(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode reversedHead = reverseList(head);

        ListNode newHead = null;
        ListNode currentNew = null;
        int carry = 0;

        ListNode currentOriginal = reversedHead;
        while (currentOriginal != null || carry != 0) {
            int digit = (currentOriginal != null) ? currentOriginal.val : 0;
            int multiplied = digit * 2 + carry;
            int newDigit = multiplied % 10;
            carry = multiplied / 10;

            ListNode newNode = new ListNode(newDigit);
            if (newHead == null) {
                newHead = newNode;
                currentNew = newHead;
            } else {
                currentNew.next = newNode;
                currentNew = currentNew.next;
            }
            if (currentOriginal != null) {
                currentOriginal = currentOriginal.next;
            }
        }
        return reverseList(newHead);
    }
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + (current.next != null ? " -> " : ""));
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MagicTicketMachine solution = new MagicTicketMachine();
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(5);
        head1.next.next = new ListNode(6);
        System.out.println("Original List 1:");
        solution.printList(head1);
        ListNode doubled1 = solution.doubleNumber(head1);
        System.out.println("Doubled List 1 (Simple):");
        solution.printList(doubled1);
        ListNode doubled1Robust = solution.doubleNumberRobust(head1);
        System.out.println("Doubled List 1 (Robust):");
        solution.printList(doubled1Robust);
        System.out.println("---");
    }
}