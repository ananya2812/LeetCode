package Arrays;

/*
 * Given an array A of non-negative integers, return an array consisting of all the even elements of
 * A, followed by all the odd elements of A.
 * 
 * You may return any answer array that satisfies this condition.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [3,1,2,4] Output: [2,4,3,1] The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be
 * accepted.
 * 
 * 
 * Note:
 * 
 * 1 <= A.length <= 5000 0 <= A[i] <= 5000
 */
public class SortArrayByParity {

  public static void main() {
    int A[] = {3, 1, 2, 4};
    int[] sortedArr = sortArrayByParity(A);
    for (int i : sortedArr) {
      System.out.println(i);
    }
  }

  public static int[] sortArrayByParity(int[] A) {
    int[] sortedArray = new int[A.length];
    int startIndex = 0;
    int endIndex = A.length - 1;
    for (int i = 0; i < A.length; i++) {
      // If data is even
      if (A[i] % 2 == 0) {
        sortedArray[startIndex++] = A[i];
      } else {
        // Data is Odd
        sortedArray[endIndex--] = A[i];
      }
    }
    return sortedArray;
  }

  public static int[] sortArrayByParityOptimal(int[] A) {
    int[] ans = new int[A.length];
    int t = 0;

    for (int i = 0; i < A.length; ++i)
      if (A[i] % 2 == 0)
        ans[t++] = A[i];

    for (int i = 0; i < A.length; ++i)
      if (A[i] % 2 == 1)
        ans[t++] = A[i];

    return ans;
  }
}
