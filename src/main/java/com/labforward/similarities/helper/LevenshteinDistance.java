package com.labforward.similarities.helper;

import org.springframework.stereotype.Component;

@Component
public class LevenshteinDistance {

  public int find(String str1, String str2) {
    char[] s1 = str1.toCharArray();
    char[] s2 = str2.toCharArray();

    var prevMemory = new int[s2.length + 1];
    for (var index = 0; index < s2.length + 1; index++) {
      prevMemory[index] = index;
    }

    for (var outer = 1; outer < s1.length + 1; outer++) {
      var current = new int[s2.length + 1];
      current[0] = outer;
      for (var inner = 1; inner < s2.length + 1; inner++) {
        int d1 = prevMemory[inner] + 1;
        int d2 = current[inner - 1] + 1;
        int d3 = prevMemory[inner - 1];
        if (s1[outer - 1] != s2[inner - 1]) {
          d3 += 1;
        }
        current[inner] = Math.min(Math.min(d1, d2), d3);
      }
      prevMemory = current;
    }
    return prevMemory[s2.length];
  }
}
