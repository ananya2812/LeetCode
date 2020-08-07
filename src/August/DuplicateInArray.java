package August;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and
 * others appear once.
 * 
 * Find all the elements that appear twice in this array.
 * 
 * Could you do it without extra space and in O(n) runtime?
 */
public class DuplicateInArray {

  public static void main(String[] args) {
    int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
    List<Integer> result = findDuplicates1(arr);
    result.forEach(System.out::println);
  }

  public static List<Integer> findDuplicates(int[] nums) {
    Set<Integer> dataSet = new HashSet<>();
    List<Integer> results = new ArrayList<>();
    for (int i : nums) {
      if (dataSet.contains(i)) {
        results.add(i);
      } else {
        dataSet.add(i);
      }
    }
    return results;
  }

  /*
   * Optimal
   */
  public static List<Integer> findDuplicates1(int[] nums) {
    List<Integer> results = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      int pos = Math.abs(nums[i]) - 1;
      if (nums[pos] >= 0) {
        nums[pos] = -nums[pos];
      } else {
        results.add(Math.abs(nums[i]));
      }
    }
    return results;
  }
}
