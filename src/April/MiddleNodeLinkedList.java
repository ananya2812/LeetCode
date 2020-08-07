package April;

public class MiddleNodeLinkedList {

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))));
    ListNode midNode = middleNode(head);
    while (midNode != null) {
      System.out.println(midNode.val);
      midNode = midNode.next;
    }
  }

  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public static ListNode middleNode(ListNode head) {
    ListNode slowPtr = head, fastPtr = head;

    while (null != fastPtr.next && null != fastPtr.next.next) {
      slowPtr = slowPtr.next;
      fastPtr = fastPtr.next.next;
    }

    // Case of Odd node
    if (fastPtr.next == null) {
      return slowPtr;
    }
    return slowPtr.next;
  }
}
