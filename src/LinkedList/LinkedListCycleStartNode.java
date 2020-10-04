package LinkedList;

/*
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * 
 * There is a cycle in a linked list if there is some node in the list that can be reached again by
 * continuously following the next pointer. Internally, pos is used to denote the index of the node
 * that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * 
 * Notice that you should not modify the linked list.
 *
 * Input: head = [3,2,0,-4], pos = 1 Output: tail connects to node index 1
 * 
 * Input: head = [1,2], pos = 0 Output: tail connects to node index 0
 * 
 * Input: head = [1], pos = -1 Output: no cycle
 * 
 */
public class LinkedListCycleStartNode {

  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public ListNode detectCycle(ListNode head) {

    ListNode fastPtr = head, slowPtr = head;
    Boolean cycleExists = false;

    while (null != fastPtr && null != fastPtr.next && null != fastPtr.next.next) {

      slowPtr = slowPtr.next;
      fastPtr = fastPtr.next.next;

      if (slowPtr == fastPtr) {
        cycleExists = true;
        break;
      }
    }

    if (cycleExists) {
      slowPtr = head;
      while (slowPtr != fastPtr) {
        slowPtr = slowPtr.next;
        fastPtr = fastPtr.next;
      }
      return slowPtr;
    }
    return null;
  }
}
