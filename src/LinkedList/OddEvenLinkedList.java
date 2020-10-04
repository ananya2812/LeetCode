package LinkedList;

/*
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note
 * here we are talking about the node number and not the value in the nodes.
 * 
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes)
 * time complexity.
 * 
 * Example 1:
 * 
 * Input: 1->2->3->4->5->NULL Output: 1->3->5->2->4->NULL Example 2:
 * 
 * Input: 2->1->3->5->6->4->7->NULL Output: 2->3->6->7->1->5->4->NULL
 */
public class OddEvenLinkedList {

  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public ListNode oddEvenList(ListNode head) {
    // Case of Empty Linked List + Only Single node in Linked List + Two Nodes in Linked List
    if (null == head || null == head.next || null == head.next.next) {
      return head;
    }

    ListNode oddEnd = head, evenHead = head.next, evenEnd = head.next;

    while (evenEnd != null && evenEnd.next != null) {
      oddEnd.next = evenEnd.next;
      oddEnd = oddEnd.next;
      evenEnd.next = oddEnd.next;
      evenEnd = evenEnd.next;
    }

    oddEnd.next = evenHead;
    return head;

  }
}
