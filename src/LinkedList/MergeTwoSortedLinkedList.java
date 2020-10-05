package LinkedList;

/*
 * Merge two sorted linked lists and return it as a new sorted list. The new list should be made by
 * splicing together the nodes of the first two lists.
 *
 * Input: l1 = [1,2,4], l2 = [1,3,4] Output: [1,1,2,3,4,4]
 * 
 * Input: l1 = [], l2 = [0] Output: [0]
 * 
 * Input: l1 = [], l2 = [] Output: []
 * 
 */
public class MergeTwoSortedLinkedList {

  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    // When both list are empty
    if (l1 == null && l2 == null) {
      return l1;
    }

    // When one of the list is empty
    if (l1 == null) {
      return l2;
    }

    if (l2 == null) {
      return l1;
    }

    ListNode l3head = null;
    if (l1.val <= l2.val) {
      l3head = new ListNode(l1.val);
      l1 = l1.next;
    } else {
      l3head = new ListNode(l2.val);
      l2 = l2.next;
    }

    ListNode currNode = l3head;

    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        ListNode newNode = new ListNode(l1.val);
        currNode.next = newNode;
        l1 = l1.next;
      } else {
        ListNode newNode = new ListNode(l2.val);
        currNode.next = newNode;
        l2 = l2.next;
      }
      currNode = currNode.next;
    }

    while (l1 != null) {
      ListNode newNode = new ListNode(l1.val);
      currNode.next = newNode;
      l1 = l1.next;
      currNode = currNode.next;
    }


    while (l2 != null) {
      ListNode newNode = new ListNode(l2.val);
      currNode.next = newNode;
      l2 = l2.next;
      currNode = currNode.next;
    }

    return l3head;
  }
}
