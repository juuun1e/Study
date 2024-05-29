package com.java.grammar;

public class AssignmentOperators {
  public static void main(String[] args) {
    // 변수를 바로 연산해서 그 자리에서 저장, 대입하는 연산자
    // 1. 기본 대입 연산자 (=)
    int number = 10;
    number = number + 2;
    System.out.println(number); // 12

    number = number - 2;
    System.out.println(number); // 10

    number = number * 2;
    System.out.println(number); // 20

    number = number / 2;
    System.out.println(number); // 10

    number = number % 2;
    System.out.println(number); // 0

    // ++ : += 1
    number = number++;
    System.out.println(number); // 2

    // -- : -= 1
    number = number--;
    System.out.println(number); // 0


    // 2. 복합 대입 연산자 (+=, -=, *=, ...)
    number = 10;

    number += 2;
    System.out.println(number); // 12

    number -= 2;
    System.out.println(number); // 10

    number *= 2;
    System.out.println(number); // 20

    number /= 2;
    System.out.println(number); // 10

    number %= 2;
    System.out.println(number); // 0
  }
}
