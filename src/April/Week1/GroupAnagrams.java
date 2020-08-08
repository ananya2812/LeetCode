package April.Week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given an array of strings, group anagrams together. Input: ["eat", "tea", "tan", "ate", "nat",
 * "bat"], Output: [ ["ate","eat","tea"], ["nat","tan"], ["bat"] ]
 * 
 */
public class GroupAnagrams {

  public static void main(String[] args) {
    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> res = groupAnagrams2(strs);
    for (int i = 0; i < res.size(); i++) {
      List val = res.get(i);
      System.out.print("[");
      for (int j = 0; j < val.size(); j++) {
        System.out.print(val.get(j));
        System.out.print(",");
      }
      System.out.println("]");
    }
  }

  public static List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List> ans = new HashMap<String, List>();
    for (String s : strs) {
      char[] ch = s.toCharArray();
      Arrays.sort(ch);
      String key = String.valueOf(ch);
      if (!ans.containsKey(key)) {
        ans.put(key, new ArrayList());
      }
      ans.get(key).add(s);
    }
    return new ArrayList(ans.values());
  }

  /*
   * Optimize
   */
  public static List<List<String>> groupAnagrams2(String[] strs) {
    Map<String, List> ans = new HashMap<String, List>();
    int[] charCount = new int[26];
    for (String s : strs) {
      Arrays.fill(charCount, 0);

      for (char c : s.toCharArray()) {
        charCount[c - 'a']++;
      }

      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < 26; i++) {
        sb.append("#");
        sb.append(charCount[i]);
      }


      String key = String.valueOf(sb.toString());
      if (!ans.containsKey(key)) {
        ans.put(key, new ArrayList());
      }
      ans.get(key).add(s);
    }
    return new ArrayList(ans.values());
  }

}
