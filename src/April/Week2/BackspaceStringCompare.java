package April.Week2;

import java.util.Stack;

/*
 * Given two strings S and T, return if they are equal when both are typed into empty text editors.
 * # means a backspace character.
 * 
 * Note that after backspacing an empty text, the text will continue empty.
 * 
 * Example 1:
 * 
 * Input: S = "ab#c", T = "ad#c" Output: true Explanation: Both S and T become "ac".
 */
public class BackspaceStringCompare {

  public static void main(String[] args) {
    String S = "a##c", T = "#a#c";
    System.out.println(compareString2(S, T));
  }

  private static Boolean compareString(String S, String T) {
    Stack<Character> sNew = new Stack<>();
    for (int i = 0; i < S.length(); i++) {
      if (S.charAt(i) == '#' && !sNew.isEmpty()) {
        sNew.pop();
      } else if (S.charAt(i) != '#') {
        sNew.add(S.charAt(i));
      }
    }

    Stack<Character> tNew = new Stack<>();
    for (int i = 0; i < T.length(); i++) {
      if (T.charAt(i) == '#' && !tNew.isEmpty()) {
        tNew.pop();
      } else if (S.charAt(i) != '#') {
        tNew.add(T.charAt(i));
      }
    }

    return sNew.equals(tNew);
  }


  /*
   * Optimized
   */
  private static Boolean compareString2(String S, String T) {
    int i = S.length() - 1;
    int j = T.length() - 1;
    int skipS = 0, skipT = 0;

    while (i >= 0 || j >= 0) {

      // Find position of next possible char in S
      while (i >= 0) {
        if (S.charAt(i) == '#') {
          skipS++;
          i--;
        } else if (skipS > 0) {
          skipS--;
          i--;
        } else {
          break;
        }
      }

      // Find position of next possible char in T
      while (j >= 0) {
        if (T.charAt(j) == '#') {
          skipT++;
          j--;
        } else if (skipT > 0) {
          skipT--;
          j--;
        } else {
          break;
        }
      }

      // If two actual characters are different
      if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) {
        return false;
      }

      // If expecting to compare char vs nothing
      if ((i >= 0) != (j >= 0)) {
        return false;
      }

      i--;
      j--;
    }

    return true;
  }

}
