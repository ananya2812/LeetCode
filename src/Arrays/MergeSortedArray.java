package Arrays;

/*
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * 
 * Note:
 * 
 * The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume
 * that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
 * Example:
 * 
 * Input: nums1 = [1,2,3,0,0,0], m = 3 nums2 = [2,5,6], n = 3
 * 
 * Output: [1,2,2,3,5,6]
 */
public class MergeSortedArray {

  public static void main(String[] args) {
    int nums1[] = {1, 2, 3, 0, 0, 0};
    int nums2[] = {2, 5, 6};
    printArray(nums1, "Printing nums1");
    printArray(nums2, "Printing nums2");
    merge(nums1, 3, nums2, nums2.length);
  }

  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    while (m > 0 && n > 0) {
      if (nums1[m - 1] > nums2[n - 1]) {
        nums1[m + n - 1] = nums1[m - 1];
        m--;
      } else {
        nums1[m + n - 1] = nums2[n - 1];
        n--;
      }
    }

    while (n > 0) {
      nums1[m + n - 1] = nums2[n - 1];
      n--;
    }
    printArray(nums1, "Printing Merged nums");

  }

  private static void printArray(int[] arr, String message) {
    System.out.println(message);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }


}
