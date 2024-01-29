package com.example.part2.ch04;

public class BinaryTest {
  public static void main(String[] args) {
    // 정수형 기본 타입 int
    int a = 10;
    // 실수형 기본 타입 = double[8byte]
    // f라는 변수는 float[4byte]형이기에, 뒤에 f 또는 F를 붙여줘야 float형으로 인식해준다.
    float f = 35.6f;
    // 논리형
    boolean b=false;
    // 문자형 - '단일문자'와 "문자열" (사용자정의자료형(->문자열 조작))
    char c='A';
    String s="APPLE";

    // Q. 69를 10진수, 2진수, 8진수, 16진수로 출력하시오.
    int decimal=69;
    System.out.println("decimal = " + decimal);
    // 2진수 0b
    int binary=0b01000101;
    System.out.println("binary = " + binary);
    // 8진수 0
    int octal=0105;
    System.out.println("octal = " + octal);
    // 16진수 0x
    int hexa=0x45;
    System.out.println("hexa = " + hexa);
  }
}
