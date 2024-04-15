package com.example.part2.ch07;

public class RelationOperTest {
  public static void main(String[] args) {
    // Q. 관계(비교)연산자의 결과 값
    int a = 4;
    System.out.println(a>5);   // False
    System.out.println(a<5);   // True
    System.out.println(a==6);  // F
    System.out.println(a!=4);  // F
    System.out.println(3>=a);  // F
    System.out.println(a<=a+1);// T
  }
}
