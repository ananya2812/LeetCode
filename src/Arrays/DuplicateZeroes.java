package Arrays;

/*
 * Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the
 * remaining elements to the right.
 * 
 * Note that elements beyond the length of the original array are not written.
 * 
 * Do the above modifications to the input array in place, do not return anything from your
 * function.
 * 
 * Input: [1,0,2,3,0,4,5,0] Output: null Explanation: After calling your function, the input array
 * is modified to: [1,0,0,2,3,0,0,4]
 * 
 * Input: [1,2,3] Output: null Explanation: After calling your function, the input array is modified
 * to: [1,2,3]
 * 
 * Tag : Medium
 */
public class DuplicateZeroes {

  public static void main(String[] args) {
    int arr[] = {1,2,3};
    printArray(arr);
    duplicateZerosOptimal(arr);
  }

  public static void duplicateZeros(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 0) {
        for (int j = arr.length - 1; j > i; j--) {
          arr[j] = arr[j - 1];
        }
        if (i + 1 < arr.length) {
          arr[i + 1] = 0;
          i++;
        }
      }
    }
    printArray(arr);
  }

  public static void duplicateZerosOptimal(int[] arr) {
    int length = arr.length - 1;
    int possibleDup = 0;

    // Counting the number of possible dup
    for (int i = 0; i <= length - possibleDup; i++) {
      if (arr[i] == 0) {
        // Check if the last of new array will be a 0 . Ex: 1,0,2,3,0,0,5,0
        if (i == length - possibleDup) {
          arr[length] = 0;
          length--;
          break;
        }
        possibleDup++;
      }
    }

    int last = length - possibleDup;
    for (int j = last; j >= 0; j--) {
      if (arr[j] == 0) {
        arr[j + possibleDup] = 0;
        possibleDup--;
        arr[j + possibleDup] = 0;
      } else {
        arr[j + possibleDup] = arr[j];
      }
    }
    printArray(arr);
  }

  private static void printArray(int[] arr) {
    System.out.println("printing array: ");
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }
}
