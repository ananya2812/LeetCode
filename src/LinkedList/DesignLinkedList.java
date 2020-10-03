package LinkedList;

public class DesignLinkedList {

  public static void main(String[] args) {
    MyLinkedList obj = new MyLinkedList();
    obj.addAtHead(7);
    obj.addAtHead(2);
    obj.addAtHead(1);
    obj.addAtIndex(3,0);
    
    obj.deleteAtIndex(2);
    obj.addAtHead(6);
    obj.addAtTail(4);
    obj.printList();
    System.out.println(obj.get(4));
  }

  static class MyLinkedList {

    Node head;

    class Node {
      private int data;
      private Node next;

      Node(int data, Node next) {
        this.data = data;
        this.next = next;
      }

      public void setData(int data) {
        this.data = data;
      }

      public void setNext(Node next) {
        this.next = next;
      }

      public int getData() {
        return data;
      }

      public Node getNext() {
        return next;
      }
    }


    /** Initialize your data structure here. */
    public MyLinkedList() {
      head = null;
    }

    public void printList() {
      Node currNode = head;
      while (currNode != null) {
        System.out.println(currNode.getData() + "->");
        currNode = currNode.getNext();
      }
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
          return curr.getData();
        }
        count++;
        curr = curr.getNext();
      }
      return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the
     * new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
      Node newNode = new Node(val, null);
      if (null != head) {
        newNode.setNext(head);
      }
      head = newNode;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {

      if (head == null) {
        addAtHead(val);
      } else {
        Node currNode = head;
        while (currNode.getNext() != null) {
          currNode = currNode.getNext();
        }

        Node newNode = new Node(val, null);
        currNode.setNext(newNode);
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


      Node newNode = new Node(val, null);
      Node currNode = head;
      int count = 1;
      while (currNode!=null) {
        if (count == index) {
          newNode.setNext(currNode.getNext());
          currNode.setNext(newNode);
          return;
        }
        count++;
        currNode = currNode.getNext();
      }

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
      if (null == head) {
        return;
      }

      if (index == 0) {
        head = head.getNext();
        return;
      }

      if (index < 0 || (head.next == null && index != 0)) {
        return;
      }



      Node prevNode = head;
      int count = 1;
      while (prevNode.getNext() != null) {
        if (count == index) {
          prevNode.setNext(prevNode.getNext().getNext());
          return;
        }
        count++;
        prevNode = prevNode.getNext();
      }
    }
  }

}
