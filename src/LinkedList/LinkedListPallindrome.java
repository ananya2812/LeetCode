package LinkedList;

/*
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Example 1:
 * 
 * Input: 1->2 Output: false Example 2:
 * 
 * Input: 1->2->2->1 Output: true
 */
public class LinkedListPallindrome {

  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public boolean isPalindrome(ListNode head) {

    if (head != null && head.next != null) {
      // Find the Middle Node
      ListNode slowPtr = head, fastPtr = head, prev_slow_node = null;
      while (fastPtr != null && fastPtr.next != null) {
        prev_slow_node = slowPtr;
        slowPtr = slowPtr.next;
        fastPtr = fastPtr.next.next;
      }

      prev_slow_node.next = null;

      ListNode secHalf = slowPtr;

      // Case of Odd Length List
      if (fastPtr != null) {
        secHalf = slowPtr.next;
      }

      // Reverse the Second Part
      secHalf = reverseList(secHalf);
      // Compare data of Two List
      return compareList(head, secHalf);

    }

    return true;
  }


  private ListNode reverseList(ListNode start) {
    ListNode currNode = start, prevNode = null, tempNode = start;

    while (currNode != null) {
      tempNode = currNode.next;
      currNode.next = prevNode;
      prevNode = currNode;
      currNode = tempNode;
    }
    start = prevNode;
    return start;
  }

  private boolean compareList(ListNode firstHalf, ListNode secHalf) {
    ListNode currNode = firstHalf;
    ListNode currSecNode = secHalf;
    while (currNode != null) {
      if (currNode.val != currSecNode.val) {
        return false;
      }
      currNode = currNode.next;
      currSecNode = currSecNode.next;
    }
    return true;
  }
}
