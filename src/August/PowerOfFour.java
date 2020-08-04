package August;

/*
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 */
public class PowerOfFour {

  public static void main(String[] args) {
    System.out.println("Is Power of 4 ?" + isPowerOfFour1(64));
  }

  public static boolean isPowerOfFour1(int num) {
    if (1 == num) {
      return true;
    }
    while (num >= 4) {
      if (num / 4 == 1 && num % 4 == 0) {
        return true;
      } else if (num % 4 != 0) {
        return false;
      }
      return isPowerOfFour1(num / 4);
    }
    return false;
  }

  /*
   * Best Runtime
   */
  public static boolean isPowerOfFour2(int num) {
    if (0 == num) {
      return false;
    }
    while (num != 1) {
      if (num % 4 != 0) {
        return false;
      }
      return isPowerOfFour2(num / 4);
    }
    return true;
  }

  public boolean isPowerOfFour3(int num) {
    if (0 == num) {
      return false;
    }
    if (Math.ceil(Math.log(num) / Math.log(4)) == Math.floor(Math.log(num) / Math.log(4))) {
      return true;
    }
    return false;
  }
}
