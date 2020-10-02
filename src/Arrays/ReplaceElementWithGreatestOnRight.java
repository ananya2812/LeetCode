package Arrays;

/*
 * Given an array arr, replace every element in that array with the greatest element among the
 * elements to its right, and replace the last element with -1.
 * 
 * After doing so, return the array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [17,18,5,4,6,1] Output: [18,6,6,6,1,-1]
 * 
 */
public class ReplaceElementWithGreatestOnRight {

  public static void main(String[] args) {
    int A[] = {17, 18, 5, 4, 6, 1};
    int result[] = replaceElements(A);
    for (int data : result) {
      System.out.println(data);
    }
  }

  public static int[] replaceElements(int[] arr) {

    int maxVal = -1, maxIndex = -1;
    for (int i = 0; i < arr.length; i++) {
      // Last Element Check
      if (i == arr.length - 1) {
        arr[i] = -1;
        return arr;
      }
      if (i >= maxIndex) {
        // Finding the next max element
        maxVal = arr[i + 1];
        maxIndex = i + 1;
        for (int j = i + 2; j < arr.length; j++) {
          if (arr[j] > maxVal) {
            maxVal = arr[j];
            maxIndex = j;
          }
        }
      }

      arr[i] = maxVal;



    }
    return arr;
  }


  public int[] replaceElementsOptimized(int[] A) {
    int max = -1, n = A.length, a;
    for (int i = n - 1; i >= 0; --i) {
      a = A[i];
      A[i] = max;
      // Computing the max for next iteration
      max = Math.max(max, a);
    }
    return A;
  }
}
