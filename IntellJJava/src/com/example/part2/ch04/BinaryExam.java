package com.example.part2.ch04;

public class BinaryExam {
  public static void main(String[] args) {
    // Q. 123를 10진수, 2진수, 8진수, 16진수로 출력하시오.
    int decimal=123;
    System.out.println("decimal = " + decimal);

    // 2진수 0b
    int binary=0b01111011;
    System.out.println("binary = " + binary);

    // 8진수 0
    int octal=0173;
    System.out.println("octal = " + octal);

    // 16진수 0x
    int hexa=0x7b;
    System.out.println("hexa = " + hexa);


    // API) java.lang에 있는 Integer 클래스 사용 : 자동화
    int data=123;
    String binary2 = Integer.toBinaryString(data);
    System.out.println("binary2 = " + binary2);

    String octal2 = Integer.toOctalString(data);
    System.out.println("octal2 = " + octal2);

    String hexa2 = Integer.toHexString(data);
    System.out.println("hexa2 = " + hexa2);
    
  }
}
