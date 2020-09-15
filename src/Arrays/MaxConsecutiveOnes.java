package Arrays;

/*
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * 
 * Input: [1,1,0,1,1,1] Output: 3 Explanation: The first two digits or the last three digits are
 * consecutive 1s. The maximum number of consecutive 1s is 3.
 */
public class MaxConsecutiveOnes {

  public static void main(String[] args) {
    int[] nums = {1, 1, 0, 1, 1, 1};
    System.out.println(findMaxConsecutiveOnes(nums));
  }

  public static int findMaxConsecutiveOnes(int[] nums) {
    int maxOnes = 0;
    int currMax = 0;
    for (int num : nums) {
      if (num == 1) {
        currMax++;
        maxOnes = Math.max(currMax, maxOnes);
      } else {
        currMax = 0;
      }
    }
    return maxOnes;
  }
}
