package com.example.part2.ch07;

public class ArithmeticOperTest {
  public static void main(String[] args) {
    // Q.나누기와 나머지 연산자의 활용(정수의 자릿수 구하기)
    int digit = 3625;
    System.out.println("일의 자리 : " + digit % 10); // 5
    System.out.println("십의 자리 : " + digit/10 % 10); // 2
    System.out.println("백의 자리 : " + digit/100 % 10); // 6
    System.out.println("천의 자리 : " + digit/1000 % 10); // 3

    System.out.println();

    int num = 2579;
    System.out.println("일의 자리 : " + num % 10); // 9
    System.out.println("십의 자리 : " + num /10 % 10); // 7
    System.out.println("백의 자리 : " + num /100 % 10); // 5
    System.out.println("천의 자리 : " + num /1000 % 10); // 2

    System.out.println();

    // 나머지 연산자 => 짝수(%2==0)인지 홀수(%2==1)인지, 배수(%n==0)
    int su = 5;
    if (su%2 == 0){
      System.out.println("짝수입니다.");
    }else {
      System.out.println("야는 홀수여유.");
    }
  }
}
