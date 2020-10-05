package LinkedList;

/*
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * 
 * There is a cycle in a linked list if there is some node in the list that can be reached again by
 * continuously following the next pointer. Internally, pos is used to denote the index of the node
 * that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * 
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * 
 * 
 */
public class LinkedListCycle {

  /**
   * Definition for singly-linked list. class ListNode { int val; ListNode next; ListNode(int x) {
   * val = x; next = null; } }
   */
  public class Solution {


    class ListNode {
      int val;
      ListNode next;

      ListNode(int x) {
        val = x;
        next = null;
      }

    }

    public boolean hasCycle(ListNode head) {
      ListNode fastPtr = head, slowPtr = head;

      while (fastPtr != null && fastPtr.next != null && fastPtr.next.next != null) {
        slowPtr = slowPtr.next;
        fastPtr = fastPtr.next.next;
        if (fastPtr == slowPtr) {
          return true;
        }
      }

      return false;
    }
  }
}
