package Easy.Array;

/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific
 * target.
 * 
 * You may assume that each input would have exactly one solution, and you may not use the same
 * element twice.
 * 
 * Example:
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 * 
 * Time Complexity : O(n^2) Space Complexity : O(1)
 */

public class TwoSum {

  public static int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    int i = 0;
    int j = 0;
    for (i = 0; i < nums.length; i++) {
      for (j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          result[0] = i;
          result[1] = j;
        }
      }

    }
    printArray(result);
    return result;
  }

  private static void printArray(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println("");
  }


  public static void main(String[] args) {
    int[] result = twoSum(new int[] {3, 2, 4}, 6);
    printArray(result);
  }
}
