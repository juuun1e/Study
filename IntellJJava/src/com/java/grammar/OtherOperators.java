package com.java.grammar;

public class OtherOperators {
  public static void main(String[] args) {
    // 1. 형변환 연산자
    int intNumber = 93 + (int) 98.8; // 93 + 98
    System.out.println(intNumber);

    double doubleNumber = (double) 93 + 98.8; // 93.0 + 98.8
    System.out.println(doubleNumber);


    // 2. 삼항 연산자 : 비교 연산자와 항상 함께 사용된다
    // 조건 ? 침 : 거짓
    int x = 1;
    int y = 9;

    boolean b = (x == y) ? true : false;
    System.out.println(b); // false

    String s = (x != y) ? "정답" : "땡";
    System.out.println(s); // 정답

    int max = (x > y) ? x : y;
    System.out.println(max); // 9

    int min = (x < y) ? x : y;
    System.out.println(min); // 1


    // 3. instance of 연산자
    // 피연산자가 조건에 명시된 클래스의 객체인지 비교
    // 맞으면 true, 틀리면 false

  }

}
