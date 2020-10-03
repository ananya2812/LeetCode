package Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and
 * others appear once.
 * 
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * 
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does
 * not count as extra space.
 * 
 * Example:
 * 
 * Input: [4,3,2,7,8,2,3,1]
 * 
 * Output: [5,6]
 */
public class FindAllNumsDisappearedInArray {

  public static void main(String[] args) {
    int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
    List<Integer> missedNums = findDisappearedNumbers(nums);
    for (Integer missNum : missedNums) {
      System.out.println(missNum);
    }
  }

  public static List<Integer> findDisappearedNumbers(int[] nums) {
    Set<Integer> uniqueEle = new HashSet<>();
    List<Integer> res = new ArrayList<>();

    for (int num : nums) {
      uniqueEle.add(num);
    }

    for (int i = 1; i <= nums.length; i++) {
      if (!uniqueEle.contains(i)) {
        res.add(i);
      }
    }
    return res;
  }

  private static List<Integer> findDisappearedNumbersOptimal(int[] nums) {

    List<Integer> missingNum = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      // this number is present in array so need to mark its position as visited
      int number = nums[i];

      // Position of that number in a 0 based sorted array would be num-1
      if (nums[Math.abs(number) - 1] > 0) {
        nums[Math.abs(number) - 1] = -nums[Math.abs(number) - 1];
      }
    }

    // The index containing positive number are the ones whose corresponding data is absent in the
    // input array
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        missingNum.add(i + 1);
      }
    }
    return missingNum;
  }
}
