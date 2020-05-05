package com.greenfoxacademy.backendapi.models;

public class SithText {
  private String sith_text;

  public SithText() {
  }

  public void reverser(Text text) {
    String reversedSentence = "";
    StringBuilder sb = new StringBuilder();
    System.out.println(text.getText());
    String[] textSentences = text.getText().split(".");
    for (String sentence : textSentences) {
      String[] words = sentence.split(" ");
        for (int i = 0; i < words.length ; i++) {
          if (i%2 == 0) sb.append(words[i]);
          else sb.append(new StringBuilder(words[i]).reverse());
          sb.append(" ");
        }
        reversedSentence += sb.toString().trim();
      }
    sith_text = reversedSentence;
    System.out.println(reversedSentence);
  }

  public String getSith_text() {
    return sith_text;
  }

  public void setSith_text(String sith_text) {
    this.sith_text = sith_text;
  }
}
