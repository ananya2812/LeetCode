package April.Week1;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a non-empty array of integers, every element appears twice except for one. Find that single
 * one.
 * 
 * Input: [2,2,1] Output: 1
 */
public class SingleNumber {

  public static void main(String[] args) {
    int[] input = {4, 4, 2};
    System.out.println(singleNumber(input));
  }

  private static int singleNumber2(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i : nums) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }

    for (int i : nums) {
      if (map.get(i) == 1) {
        return i;
      }
    }
    return 0;
  }


  /*
   * XOR(a,0) = a | XOR(a,a) = 0
   */
  private static int singleNumber(int[] nums) {
    int a = 0;
    for (int i = 0; i < nums.length; i++) {
      a ^= nums[i];
    }
    return a;
  }

}
