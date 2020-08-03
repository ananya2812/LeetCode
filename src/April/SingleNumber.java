package April;

public class SingleNumber {

  public static void main(String[] args) {
    int[] input = {4, 4, 2};
    System.out.println(singleNumber(input));
  }

  private static int singleNumber(int[] nums) {
    int a = 0;
    for (int i = 0; i < nums.length; i++) {
      a ^= nums[i];
    }
    return a;
  }
}
