package com.java.grammar;

public class LogicalOperator {
  public static void main(String[] args) {
    // 논리연산자 : 비교 연산의 결과값으로 받을 수 있는 boolean 값을 연결하는 연산자
    // 조건을 연결하였을 때 boolean 값들을 조합하여 참 또는 거짓 값을 출력
    // &&(and), ||(or), !(not)
    boolean flag1 = true;
    boolean flag2 = true;
    boolean flag3 = false;

    System.out.println(flag1); // true
    System.out.println(flag2); // true
    System.out.println(flag3); // false

    // 피연산자 중 하나라도 true 이면 true
    System.out.println(flag1 || flag2); // true
    System.out.println(flag1 || flag2 || flag3); // true

    // 피연산자 모두 true 이면 true
    System.out.println(flag1 && flag2); // true (flag1, flag2 모두 true 라서)
    System.out.println(flag1 && flag2 && flag3); // false (flag3은 false 라서)

    // And 연산
    System.out.println((5 > 3) && (3 > 1)); // 5 는 3 보다 크고, 3 은 1 보다 크다 (true)
    System.out.println((5 > 3) && (3 < 1)); // 5 는 3 보다 크고, 3 은 1 보다 작다 (false)

    // Or 연산
    System.out.println((5 > 3) || (3 > 1)); // 5 는 3 보다 크거나, 3 은 1 보다 크다 (true)
    System.out.println((5 > 3) || (3 < 1)); // 5 는 3 보다 크거나, 3 은 1 보다 작다 (true)
    System.out.println((5 < 3) || (3 < 1)); // 5 는 3 보다 작거나, 3 은 1 보다 작다 (false)

    // System.out.println(1 < 3 < 5); // 불가능한 코드

    // 논리 부정 연산자
    System.out.println(!flag1); // false (flag1 값의 반대)
    System.out.println(!flag3); // true (flag3 값의 반대)
    System.out.println(!(5 == 5)); // false
    System.out.println(!(5 == 3)); // true
  }
}
