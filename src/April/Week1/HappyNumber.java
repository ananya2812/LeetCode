package April.Week1;

import java.util.HashSet;

/*
 * Write an algorithm to determine if a number n is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with any positive integer,
 * replace the number by the sum of the squares of its digits, and repeat the process until the
 * number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 * 
 * Return True if n is a happy number, and False if not.
 * 
 * Example:
 * 
 * Input: 19 Output: true Explanation: 1^2 + 9^2 = 82 | 8^2 + 2^2 = 68 | 6^2 + 8^2 = 100 | 1^2 + 0^2
 * + 0^2 = 1
 */
public class HappyNumber {

  public static void main(String[] args) {
    System.out.println(isHappy(19));
  }

  private static boolean isHappy(int n) {
    HashSet<Integer> numSet = new HashSet<>();
    while (!numSet.contains(n)) {
      numSet.add(n);
      // Find Sum of its digits square
      n = findSum(n);
      if (n == 1) {
        return true;
      }
    }
    return false;
  }

  private static int findSum(int n) {
    int sum = 0;
    while (n != 0) {
      int dig = n % 10;
      sum += (dig * dig);
      n = n / 10;
    }
    return sum;
  }
}
