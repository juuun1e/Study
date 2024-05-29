package com.java.grammar;

public class OperatorPrecedence {
  public static void main(String[] args) {
    // 연산자 우선순위 : 산술 > 비교 > 논리 > 대입
    int x = 2;
    int y = 9;
    int z = 10;

    boolean result = x < y && y < z; // <,> 비교연산자 계산 후 && 논리 연산자 계산
    System.out.println(result); // true

    result = x + 10 < y && y < z; // +10 산술연산자 계산 후 <,> 비교연산자 계산 후 && 논리 연산자 계산
    System.out.println(result); // false

    result = x + 2 * 3 > y; // 산술연산자 곱셈 > 덧셈 순으로 계산 후 > 비교연산자 계산
    System.out.println(result); // false (8>9)

    result = (x + 2) * 3 > y; // 괄호 안 덧셈 연산 후 괄호 밖 곱셈 계산 후 > 비교연산자 계산
    System.out.println(result); // true (12>9)
  }
}
