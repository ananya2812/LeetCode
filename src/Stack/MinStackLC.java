package Stack;

import java.util.Stack;

/*
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 * push(x) -- Push element x onto stack. pop() -- Removes the element on top of the stack. top() --
 * Get the top element. getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStackLC {

  public static void main(String[] args) {
    MinStack obj = new MinStack();
    obj.push(2);
    obj.pop();
    System.out.println(obj.top());
    System.out.println("minimum: " + obj.getMin());
  }

  static class MinStack {

    /** initialize your data structure here. */


    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
      stack = new Stack<>();
      minStack = new Stack<>();
    }

    public void push(int x) {
      int data = x;
      if (!minStack.isEmpty()) {
        if (minStack.peek() < x) {
          data = minStack.peek();
        }
      }
      stack.push(x);
      minStack.push(data);
    }

    public void pop() {
      stack.pop();
      minStack.pop();
    }

    public int top() {
      return stack.peek();
    }

    public int getMin() {
      return minStack.peek();
    }
  }

}
