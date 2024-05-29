package com.java.grammar;

public class ArithmeticConversion {
  public static void main(String[] args) {
    // 산술 변환
    short x = 10;
    int y = 20;

    int z = x + y; // 결과값은 더 큰 표현타입인 int 타입의 변수로만 저장

    long lx = 30L;
    long lz = z + lx; // 결과값은 더 큰 표현타입인 long 타입의 변수로만 저장

    float fx = x; // 결과값은 더 큰 표현타입인 float 타입의 변수로만 저장
    float fy = y; // 결과값은 더 큰 표현타입인 float 타입의 변수로만 저장
    float fz = z; // 결과값은 더 큰 표현타입인 float 타입의 변수로만 저장

    System.out.println(lz); // 60
    System.out.println(fx); // 10.0
    System.out.println(fy); // 20.0
    System.out.println(fz); // 30.0
  }
}
