package Arrays;

/*
 * Given a non-empty array of integers, return the third maximum number in this array. If it does
 * not exist, return the maximum number. The time complexity must be in O(n).
 * 
 * Example 1: Input: [3, 2, 1]
 * 
 * Output: 1
 * 
 * Explanation: The third maximum is 1. Example 2: Input: [1, 2]
 * 
 * Output: 2
 * 
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead. Example 3:
 * Input: [2, 2, 3, 1]
 * 
 * Output: 1
 * 
 * Explanation: Note that the third maximum here means the third maximum distinct number. Both
 * numbers with value 2 are both considered as second maximum.
 */
public class ThirdMax {

  public static void main(String[] args) {
    int[] nums = {3, 2, 1};
    System.out.println(thirdMax(nums));
  }

  public static int thirdMax(int[] nums) {
    Integer firstMax = null, secMax = null, thirdMax = null;

    for (Integer data : nums) {

      // Not a distict number
      if (data.equals(firstMax) || data.equals(secMax) || data.equals(thirdMax)) {
        continue;
      }

      if (null == firstMax || data > firstMax) {
        thirdMax = secMax;
        secMax = firstMax;
        firstMax = data;
      } else if (null == secMax || data > secMax) {
        thirdMax = secMax;
        secMax = data;
      } else if (null == thirdMax || data > thirdMax) {
        thirdMax = data;
      }

    }

    return (thirdMax == null) ? firstMax : thirdMax;

  }
}
