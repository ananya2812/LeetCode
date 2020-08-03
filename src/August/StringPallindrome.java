package August;

import java.util.Stack;

public class StringPallindrome {

  public static void main(String[] args) {
    String s = "A man, a plan, a canal: Panama";
    System.out.println(isPalindrome(s));
  }

  public static boolean isPalindrome(String s) {
    if (s.equals("")) {
      return true;
    }

    Stack<Character> ch = new Stack<>();
    String sl = s.toLowerCase();
    for (int i = 0; i < sl.length(); i++) {
      if (Character.isLetterOrDigit(sl.charAt(i))) {
        ch.push(sl.charAt(i));
      }
    }
    Boolean isPallindrome = true;
    for (int i = 0; i < sl.length(); i++) {
      if (Character.isLetterOrDigit(sl.charAt(i)) && sl.charAt(i) != ch.pop()) {
        isPallindrome = false;
        break;
      }
    }
    return isPallindrome;
  }
}
