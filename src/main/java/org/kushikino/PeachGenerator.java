package org.kushikino;

public class PeachGenerator {

  public String getPeaches() {
    StringBuilder result = new StringBuilder();
    for (int i = 1; i <= 50; i++) {
      for (int j = 1; j < i; j++) {
        result.append("&#12288");
      }
      result.append("桃<br>");
    }
    return result.toString();
  }

}
