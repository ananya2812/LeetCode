package LinkedList;

/*
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * 
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3 Output:
 * Reference of the node with value = 8
 * 
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2 Output: null
 */
public class IntersectionOfTwoLinkedList {

  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

    // Calculate Length of List
    int lenA = lengthOfLinkedList(headA);
    int lenB = lengthOfLinkedList(headB);

    int diff = Math.abs(lenA - lenB);

    ListNode longList = (lenA > lenB) ? headA : headB;

    int index = 0;
    while (index != diff) {
      longList = longList.next;
      index++;
    }

    ListNode smallList = (lenA > lenB) ? headB : headA;

    while (smallList != null) {
      if (longList == smallList) {
        return smallList;
      }
      smallList = smallList.next;
      longList = longList.next;
    }
    return null;
  }

  private int lengthOfLinkedList(ListNode head) {
    ListNode currNode = head;
    int count = 0;
    while (currNode != null) {
      count++;
      currNode = currNode.next;
    }
    return count;
  }
}
