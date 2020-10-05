package LinkedList;

/*
 * You are given two non-empty linked lists representing two non-negative integers. The digits are
 * stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and
 * return the sum as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Input: l1 = [2,4,3], l2 = [5,6,4] Output: [7,0,8]
 * 
 * Input: l1 = [0], l2 = [0] Output: [0]
 * 
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] Output: [8,9,9,9,0,0,0,1]
 */
public class AddTwoNumbers {
  
  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    if (null == l2) {
      return l1;
    }

    if (null == l1) {
      return l2;
    }

    int sum = l1.val + l2.val;
    ListNode l3head = new ListNode(sum % 10);
    int carry = (sum != 0) ? sum / 10 : 0;
    l1 = l1.next;
    l2 = l2.next;

    ListNode currNode = l3head;

    while (l1 != null || l2 != null || carry != 0) {
      int num1 = (l1 != null) ? l1.val : 0;
      int num2 = (l2 != null) ? l2.val : 0;
      int newSum = num1 + num2 + carry;
      currNode.next = new ListNode(newSum % 10);
      carry = (newSum != 0) ? newSum / 10 : 0;
      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
      currNode = currNode.next;
    }
    return l3head;
  }
}
