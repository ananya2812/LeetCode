package Easy.HashTable;

import java.util.HashMap;

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
 * Time Complexity : O(n) Space Complexity : O(n)
 */
public class TwoSum {

  public static int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[] {map.get(complement), i};
      }
      map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
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
