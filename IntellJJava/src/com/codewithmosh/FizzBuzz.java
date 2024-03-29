package com.codewithmosh;

import java.util.Scanner;

public class FizzBuzz {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Number: ");
    int number = sc.nextInt();

    // 가장 구체적인 조건을 if블록에 : 참일 경우 아래 블록은 건너뛰기 때문
    if (number % 3 == 0 && number % 5 == 0){
      System.out.println("FizzBuzz");
    }
    else if (number % 3 == 0)
      System.out.println("Buzz");
    else if (number % 5 == 0)
      System.out.println("Fizz");
    else
      System.out.println(number);
  }
}
