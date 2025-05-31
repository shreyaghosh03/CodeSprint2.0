import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseStringListSegment {
    public static class ListNode {
        String val;
        ListNode next;
        ListNode() {}
        ListNode(String val) { this.val = val; }
        ListNode(String val, ListNode next) { this.val = val; this.next = next; }
    }
    public String[] reverseBetween(String[] headArray, int left, int right) {
        if (headArray == null || headArray.length == 0 || left < 1 || right > headArray.length || left > right) {
            return headArray; 
        }
        ListNode dummy = new ListNode("dummy_val"); 
        ListNode currentListNode = dummy;
        for (String s : headArray) {
            currentListNode.next = new ListNode(s);
            currentListNode = currentListNode.next;
        }
        ListNode head = dummy.next; 
        ListNode actualDummy = new ListNode("temp", head); 
        ListNode prevLeft = actualDummy;
        for (int i = 0; i < left - 1; i++) {
            prevLeft = prevLeft.next;
        }
        ListNode startNode = prevLeft.next; 
        ListNode prev = startNode; 
        ListNode current = startNode.next;
        ListNode nextNode;

        for (int i = 0; i < right - left; i++) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        prevLeft.next = prev;     
        startNode.next = current; 
        ListNode finalHead = actualDummy.next;
        List<String> resultList = new ArrayList<>();
        currentListNode = finalHead;
        while (currentListNode != null) {
            resultList.add(currentListNode.val);
            currentListNode = currentListNode.next;
        }
        return resultList.toArray(new String[0]);
    }
    public static void main(String[] args) {
        ReverseStringListSegment reverser = new ReverseStringListSegment();
        String[] headArray1 = {"Bread", "Eggs", "Milk", "Cheese", "Tomatoes"};
        String[] reversedArray1 = reverser.reverseBetween(headArray1, 2, 4);
        System.out.println("Example 1 Input: " + Arrays.toString(headArray1) + ", left=2, right=4");
        System.out.println("Example 1 Output: " + Arrays.toString(reversedArray1));
    }
}