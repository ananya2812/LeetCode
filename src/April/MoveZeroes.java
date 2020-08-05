package April;

/*
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the
 * relative order of the non-zero elements.
 * 
 * Input: [0,1,0,3,12] Output: [1,3,12,0,0]
 */
public class MoveZeroes {

  public static void main(String[] args) {
    int[] nums = {0, 1, 0, 3, 12};
    System.out.println("Before Zeroes Movement");
    for (int i : nums) {
      System.out.println(i);
    }
    System.out.println("After Zeroes Movement");
    moveZeroes(nums);
    for (int i : nums) {
      System.out.println(i);
    }
  }

  public static void moveZeroes1(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        int nextNonZeroNum = 0, index = -1;
        for (int j = i + 1; j < nums.length; j++) {
          if (nums[j] != 0) {
            nextNonZeroNum = nums[j];
            index = j;
            break;
          }
        }
        if (index != -1) {
          nums[i] = nextNonZeroNum;
          nums[index] = 0;
        }
      }
    }
  }

  /*
   * Optimal
   */
  public static void moveZeroes(int[] nums) {
    for (int lastNonZeroPostition = 0, curr = 0; curr < nums.length; curr++) {
      if (nums[curr] != 0) {
        // Need swap because of test case [1]
        int temp = nums[lastNonZeroPostition];
        nums[lastNonZeroPostition] = nums[curr];
        nums[curr] = temp;
        lastNonZeroPostition++;
      }
    }
  }
}
