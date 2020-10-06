package Stack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/*
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the
 * input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets. Open brackets must be closed in the
 * correct order.
 * 
 */
public class ValidParenthesis {

  public static void main(String[] args) {
    System.out.println("Is Valid Parenthesis? " + isValid("[]"));
  }

  public static boolean isValid(String s) {

    Map<Character, Character> paraenthesisMap = new HashMap<>();
    paraenthesisMap.put('}', '{');
    paraenthesisMap.put(')', '(');
    paraenthesisMap.put(']', '[');

    Set<Character> openingParenthesis = new HashSet<>();
    openingParenthesis.addAll(paraenthesisMap.values());

    Stack<Character> st = new Stack<>();
    try {
      for (int i = 0; i < s.length(); i++) {
        Character data = s.charAt(i);
        if (openingParenthesis.contains(data)) {
          st.push(data);
        }
        if (paraenthesisMap.containsKey(data)) {

          if (paraenthesisMap.get(data) != st.pop()) {
            return false;
          }
        }
      }
    } catch (Exception e) {
      return false;
    }
    return st.isEmpty();

  }
}
