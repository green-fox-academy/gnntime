package exercises;

import static org.junit.Assert.*;


import org.junit.Test;

public class AnagramTest {

  @Test
  public void areTheseAnagrams() {
    Anagram anagram = new Anagram();
    assertTrue(Anagram.isAnagram("alma", "lama"));
  }
  @Test
  public void areTheseAnagrams2() {
    Anagram anagram = new Anagram();
    assertFalse(Anagram.isAnagram("bribe", "hider"));
  }
  @Test
  public void areTheseAnagramsCapital() {
    Anagram anagram = new Anagram();
    assertTrue(Anagram.isAnagram("Anna", "nana"));
  }
}