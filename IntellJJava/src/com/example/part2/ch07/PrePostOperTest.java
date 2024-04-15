package com.example.part2.ch07;

public class PrePostOperTest {
  public static void main(String[] args) {
    // 증감연산자 위치에 따는 해석
    int a = 10;
    System.out.println(--a); // a-1=a; // 9
    System.out.println(a++); // a=a+1; // 9 // 나중에 더해서 저장된 값은 10
    System.out.println(a--); // a=a-1; // 10 // 나중에 빼서 저장된 값은 9
    System.out.println(++a); // a+1=a; // 10 // 9+1=10
    System.out.println(a); // 10
  }
}
