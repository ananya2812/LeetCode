package LinkedList;

/*
 * Design your implementation of the linked list. You can choose to use a singly or doubly linked
 * list. A node in a singly linked list should have two attributes: val and next. val is the value
 * of the current node, and next is a pointer/reference to the next node. If you want to use the
 * doubly linked list, you will need one more attribute prev to indicate the previous node in the
 * linked list. Assume all nodes in the linked list are 0-indexed.
 */
public class DesignDoublyLinkedList {

  public static void main(String[] args) {
    MyLinkedList obj = new MyLinkedList();
    obj.addAtHead(7);
    obj.addAtHead(2);
    obj.addAtHead(1);
    obj.addAtIndex(3, 0);

    obj.deleteAtIndex(2);
    obj.addAtHead(6);
    obj.addAtTail(4);
    System.out.println(obj.get(4));
  }

  static class MyLinkedList {

    Node head;

    class Node {
      int data;
      Node next;
      Node prev;

      Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
      }

    }

    /** Initialize your data structure here. */
    public MyLinkedList() {
      head = null;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
      if (head == null) {
        return -1;
      }
      Node curr = head;
      int count = 0;
      while (curr != null) {
        if (count == index) {
          return curr.data;
        }
        count++;
        curr = curr.next;
      }
      return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the
     * new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
      Node newNode = new Node(val, head, null);
      if (null != head) {
        head.prev = newNode;
      }
      head = newNode;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
      if (head == null) {
        addAtHead(val);
      } else {
        Node lastNode = head;
        while (lastNode.next != null) {
          lastNode = lastNode.next;
        }
        Node newNode = new Node(val, null, lastNode);
        newNode.prev.next = newNode;
      }
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the
     * length of linked list, the node will be appended to the end of linked list. If index is
     * greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
      if (index == 0) {
        addAtHead(val);
        return;
      }

      if (null == head && index != 0) {
        return;
      }


      if (index < 0 || (head.next == null && index > 1)) {
        return;
      }


      Node newNode = new Node(val, null, null);
      Node currNode = head;
      int count = 0;
      while (currNode != null) {
        if (count == index) {
          newNode.prev = currNode.prev;
          newNode.prev.next = newNode;
          newNode.next = currNode;
          newNode.next.prev = newNode;
        }
        count++;
        currNode = currNode.next;
      }
      if (count == index) {
        addAtTail(val);
      }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
      if (null == head) {
        return;
      }

      if (index == 0) {
        head = head.next;
        return;
      }

      if (index < 0 || (head.next == null && index != 0)) {
        return;
      }

      Node currNode = head;
      int count = 0;
      while (currNode != null) {
        if (count == index) {
          currNode.prev.next = currNode.next;
          if (currNode.next != null) {
            currNode.next.prev = currNode.prev;
          }
          return;
        }
        count++;
        currNode = currNode.next;
      }
    }
  }
}
