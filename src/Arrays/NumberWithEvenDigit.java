package Arrays;

/*
 * Given an array nums of integers, return how many of them contain an even number of digits.
 * 
 * Input: nums = [12,345,2,6,7896] Output: 2
 */
public class NumberWithEvenDigit {

  public static void main(String[] args) {
    int[] nums = {12, 345, 2, 6, 7896};
    System.out.println(findNumbers(nums));
  }

  public static int findNumbers(int[] nums) {
    int evenNumCount = 0;
    for (int num : nums) {
      if (getDigitCount(num) % 2 == 0) {
        evenNumCount++;
      }
    }
    return evenNumCount;
  }

  private static int getDigitCount(int num) {
    int count = 0;
    do {
      count++;
      num = num / 10;
    } while (num > 0);
    return count;
  }
}
