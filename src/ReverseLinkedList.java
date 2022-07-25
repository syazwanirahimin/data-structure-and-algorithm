import java.util.List;

/**
 * a linked list can be reversed either iteratively or recursively
 */

// reverse a singly linked list
    // input: 1->2->3->4->5->NULL
    // output: 5->4->3->2->1->NULL
    // time complexity = O(n)
public class ReverseLinkedList {

    public ListNode reverseListIterative(ListNode head) {
        // initialise 2 nodes
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return  prev;
    }

    public ListNode reverseListRecursive(ListNode head) {
        return reverse(head, null);
    }

    private ListNode reverse(ListNode head, ListNode newHead){
        if (head == null) {
            return newHead;
        }

        ListNode next = head.next;
        head.next = newHead;
        newHead = head;
        head = next;

        return reverse(head, newHead);
    }

    public static void main(String[] args) {
        ReverseLinkedList test = new ReverseLinkedList();
    }

}


