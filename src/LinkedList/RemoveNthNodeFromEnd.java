package LinkedList;

/*
 * Given the head of a linked list, remove the nth node from the end of the list and return its
 * head.
 * 
 * Input: head = [1,2,3,4,5], n = 2 Output: [1,2,3,5]
 */
public class RemoveNthNodeFromEnd {

  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }


  public ListNode removeNthFromEnd(ListNode head, int n) {
    // Deleting Last Node;
    if (n == 1) {
      ListNode currNode = head;
      // Only 1 node
      if (currNode.next == null) {
        return null;
      }
      while (currNode.next.next != null) {
        currNode = currNode.next;
      }
      currNode.next = null;
      return head;
    }

    int len = lengthOfList(head);
    int diff = len - n;
    int index = 1;

    // Deleting Complete List
    if (diff == 0) {
      head = head.next;
      return head;
    }

    // Deleting any other node
    ListNode currNode = head;
    while (index != diff) {
      currNode = currNode.next;
      index++;
    }
    currNode.next = currNode.next.next;
    return head;
  }

  private int lengthOfList(ListNode head) {
    ListNode currNode = head;
    int count = 0;
    while (currNode != null) {
      count++;
      currNode = currNode.next;
    }
    return count;
  }

  public ListNode removeNthFromEndOptimal(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    ListNode slowPtr = dummy, fastPtr = dummy;

    for (int i = 0; i <= n; i++) {
      fastPtr = fastPtr.next;
    }

    while (fastPtr != null) {
      fastPtr = fastPtr.next;
      slowPtr = slowPtr.next;
    }

    slowPtr.next = slowPtr.next.next;
    return dummy.next;
  }
}
