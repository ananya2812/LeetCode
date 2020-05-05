package Easy.Array;

/*
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than
 * it. That is, for each nums[i] you have to count the number of valid j's such that j != i and
 * nums[j] < nums[i].
 * 
 * Return the answer in an array.
 * 
 * Input: nums = [6,5,4,8] Output: [2,1,0,3]
 * 
 */
public class SmallerNumbersThanCurrent {

  public static void main(String[] args) {
    int[] nums = {6, 5, 4, 8};
    int[] result = smallerNumbersThanCurrent(nums);
    printArray(result);
  }

  private static void printArray(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println("");
  }

  private static int[] smallerNumbersThanCurrent(int[] nums) {
    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      int count = 0;
      for (int j = 0; j < nums.length; j++) {
        if (nums[i] > nums[j]) {
          count++;
        }
        result[i] = count;
      }
    }
    return result;
  }
}
