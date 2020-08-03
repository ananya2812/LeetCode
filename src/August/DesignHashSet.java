package August;

public class DesignHashSet {

  public static void main(String[] args) {
    MyHashSet obj = new MyHashSet();
    int key = 100;
    System.out.println(obj.contains(key));
    obj.add(key);
    System.out.println(obj.contains(key));
    obj.remove(key);
    System.out.println(obj.contains(key));
  }

}


class MyHashSet {

  class Node {
    int data;
    Node next;

    Node(int val) {
      this.data = val;
    }
  }

  int size;
  Node[] arrayNode;

  public MyHashSet() {
    size = 100;
    arrayNode = new Node[100];
  }

  public void add(int newData) {
    int index = (newData % this.size);
    // When the index of this key does not exists already
    if (this.arrayNode[index] == null) {
      this.arrayNode[index] = new Node(newData);
      return;
    }

    // When the index exits and Data also exits
    Node currNode = this.arrayNode[index];
    while (currNode != null && currNode.data != newData) {
      currNode = currNode.next;
    }
    if (null != currNode) {
      return;
    }

    // When the index exits and Data does not exits i.e. Data is new

    Node newHead = new Node(newData);
    newHead.next = this.arrayNode[index];
    this.arrayNode[index] = newHead;

  }

  public void remove(int newData) {
    int index = (newData % this.size);
    Node currNode = this.arrayNode[index];
    // Index does not exists
    if (null == currNode) {
      return;
    } else {
      // Index Exists - Check if it is the head node
      if (currNode.data == newData) {
        this.arrayNode[index] = this.arrayNode[index].next;
        return;
      } else {
        // Index Exists - Check if it is NOT the head node
        while (currNode.next != null && currNode.next.data != newData) {
          currNode = currNode.next;
        }

        // When you reach last node and do not find the data
        if (currNode.next == null) {
          return;
        }
        currNode.next = currNode.next.next;
      }
    }
  }

  /** Returns true if this set contains the specified element */
  public boolean contains(int newData) {
    int index = (newData % this.size);
    Node currNode = this.arrayNode[index];
    // When Index does not exists
    if (null == currNode) {
      return false;
    } else {
      // When Index exits - Traverse the LL to check if data exists
      while (currNode != null && currNode.data != newData) {
        currNode = currNode.next;
      }

      return (null != currNode);
    }
  }
}
