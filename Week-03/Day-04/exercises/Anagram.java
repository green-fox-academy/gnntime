package exercises;

import java.util.Arrays;

public class Anagram {

  public static boolean isAnagram(String word1, String word2) {
    if (word1.length() != word2.length()) {
      return false;
    }
    char[] word1Array = word1.toLowerCase().toCharArray();
    char[] word2Array = word2.toLowerCase().toCharArray();
    Arrays.sort(word1Array);
    Arrays.sort(word2Array);
    for (int i = 0; i < word1.length() ; i++) {
      if (word1Array[i] != word2Array[i]) {
        return false;
      }
    }
   return true;
  }
}
