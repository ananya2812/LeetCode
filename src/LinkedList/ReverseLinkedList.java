package LinkedList;

/*
 * Reverse a singly linked list.
 * 
 * Example:
 * 
 * Input: 1->2->3->4->5->NULL Output: 5->4->3->2->1->NULL
 */
public class ReverseLinkedList {

  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }


  public ListNode reverseList(ListNode head) {
    ListNode tempNode = head, currNode = head;
    ListNode prevNode = null;

    while (currNode != null) {
      tempNode = tempNode.next;
      currNode.next = prevNode;
      prevNode = currNode;
      currNode = tempNode;
    }
    head = prevNode;
    return head;
  }
}
