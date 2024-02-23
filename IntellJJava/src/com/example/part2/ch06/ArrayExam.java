package com.example.part2.ch06;

public class ArrayExam {
  public static void main(String[] args) {
    // Q.char[]배열에 APPLE이라는 문자가 저장되어 있다. 대문자로 된 APPLE을 소문자apple로 출력하세요.
    char[]c={'A','P','P','L','E'};
    for (int i = 0; i < c.length ; i++) {
      System.out.println((char)(c[i]+32));

    }
  }
}
