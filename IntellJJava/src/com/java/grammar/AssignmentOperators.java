package com.java.grammar;

public class AssignmentOperators {
  public static void main(String[] args) {
    // 대입 연산자
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

    number = number++;
    System.out.println(number); // 2

    number = number--;
    System.out.println(number); // 0


    // 복합 대입 연산자
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
