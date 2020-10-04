package LinkedList;

/*
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example:
 * 
 * Input: 1->2->6->3->4->5->6, val = 6 Output: 1->2->3->4->5
 */
public class RemoveLinkedListElement {

  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public ListNode removeElements(ListNode head, int val) {
    // Removing all matching val from head of list
    while (head != null && head.val == val) {
      head = head.next;
    }

    // List becomes empty
    if (head == null) {
      return head;
    }

    ListNode currNode = head;
    while (currNode.next != null) {
      if (currNode.next.val == val) {
        currNode.next = currNode.next.next;
      } else {
        currNode = currNode.next;
      }
    }
    return head;
  }
}
