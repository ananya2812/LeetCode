package August;

public class DetectCapital {

  public static void main(String[] args) {
    String word = "ANanaya";
    System.out.println(detectCapitalUse(word));
  }

  public static boolean detectCapitalUse(String word) {
    if (word.toUpperCase().equals(word)) {
      return true;
    } else if (word.toLowerCase().equals(word)) {
      return true;
    } else if (word.substring(0,0).toUpperCase().equals(word.substring(0,0))
        && word.substring(1).toLowerCase().equals(word.substring(1))) {
      return true;
    } else {
      return false;
    }
  }
}
