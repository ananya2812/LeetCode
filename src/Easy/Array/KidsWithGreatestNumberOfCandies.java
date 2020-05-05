package Easy.Array;

import java.util.ArrayList;
import java.util.List;

/*
 * Given the array candies and the integer extraCandies, where candies[i] represents the number of
 * candies that the ith kid has.
 * 
 * For each kid check if there is a way to distribute extraCandies among the kids such that he or
 * she can have the greatest number of candies among them. Notice that multiple kids can have the
 * greatest number of candies.
 * 
 * Input: candies = [4,2,1,1,2], extraCandies = 1 Output: [true,false,false,false,false]
 * Explanation: There is only 1 extra candy, therefore only kid 1 will have the greatest number of
 * candies among the kids regardless of who takes the extra candy.
 */
public class KidsWithGreatestNumberOfCandies {

  public static void main(String[] args) {
    int[] candies = {4, 2, 1, 1, 2};
    int extraCandies = 1;
    List<Boolean> result = kidsWithCandies(candies, extraCandies);
    System.out.println(result);
  }

  public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    List<Boolean> result = new ArrayList<>();
    int max = candies[0];
    for (int i = 1; i < candies.length; i++) {
      if (candies[i] > max) {
        max = candies[i];
      }
    }
    for (int i = 0; i < candies.length; i++) {
      if (candies[i] + extraCandies >= max) {
        result.add(true);
      } else {
        result.add(false);
      }
    }
    return result;
  }
}
