package Arrays;

import java.util.Arrays;

/*
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of
 * each number, also in sorted non-decreasing order.
 * 
 * Input: [-4,-1,0,3,10] Output: [0,1,9,16,100]
 * 
 * Tag: Medium
 */

public class SquareOfSortedArray {

  public static void main(String[] args) {
    int[] nums = {-4,-1,0,3,10};
    int[] sortedSquareArr = sortedSquaresOptimal(nums);
    System.out.println(sortedSquareArr);
  }

  public static int[] sortedSquares(int[] A) {
    int[] squareA = new int[A.length];
    for (int i = 0; i < A.length; i++) {
      squareA[i] = A[i] * A[i];
    }
    Arrays.sort(squareA);
    return squareA;
  }

  public static int[] sortedSquaresOptimal(int[] A) {
    int firstPosNumIndex = 0, lastNegNumIndex = 0;
    int arrLength = A.length;
    while (firstPosNumIndex < arrLength && A[firstPosNumIndex] < 0) {
      firstPosNumIndex++;
    }
    lastNegNumIndex = firstPosNumIndex - 1;

    int[] squareArr = new int[arrLength];
    int currIndex = 0;

    while (firstPosNumIndex < arrLength && lastNegNumIndex >= 0) {
      if (A[lastNegNumIndex] * A[lastNegNumIndex] < A[firstPosNumIndex] * A[firstPosNumIndex]) {
        squareArr[currIndex++] = A[lastNegNumIndex] * A[lastNegNumIndex];
        lastNegNumIndex--;
      } else {
        squareArr[currIndex++] = A[firstPosNumIndex] * A[firstPosNumIndex];
        firstPosNumIndex++;
      }
    }

    while (lastNegNumIndex >= 0) {
      squareArr[currIndex++] = A[lastNegNumIndex] * A[lastNegNumIndex];
      lastNegNumIndex--;
    }
    
    while (firstPosNumIndex < arrLength) {
      squareArr[currIndex++] =A[firstPosNumIndex] * A[firstPosNumIndex];
      firstPosNumIndex++;
    }
    return squareArr;
  }

}
