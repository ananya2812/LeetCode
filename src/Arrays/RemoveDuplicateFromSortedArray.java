package Arrays;

/*
 * Given a sorted array nums, remove the duplicates in-place such that each element appears only
 * once and returns the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying the input array
 * in-place with O(1) extra memory.
 * 
 * Example 1:
 * 
 * Given nums = [1,1,2],
 * 
 * Your function should return length = 2, with the first two elements of nums being 1 and 2
 * respectively.
 * 
 * It doesn't matter what you leave beyond the returned length. Example 2:
 * 
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * 
 * Your function should return length = 5, with the first five elements of nums being modified to 0,
 * 1, 2, 3, and 4 respectively.
 * 
 * It doesn't matter what values are set beyond the returned length.
 */
public class RemoveDuplicateFromSortedArray {

  public static void main(String[] args) {
    int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    int len = removeDuplicates(nums);
    for (int i = 0; i < len; i++) {
      System.out.println(nums[i]);
    }
  }

  public static int removeDuplicates(int[] nums) {

    int count = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[i - 1]) {
        nums[count] = nums[i];
        count++;
      }
    }
    return count;
  }
}
