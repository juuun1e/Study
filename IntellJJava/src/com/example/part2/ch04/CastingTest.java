package com.example.part2.ch04;

public class CastingTest {
  public static void main(String[] args) {
    // 실수형 float
    float f1=.10f; // 0.10
    System.out.println("f1 = " + f1);
    float f2=15f; //15.0
    System.out.println("f2 = " + f2);
    float f3=(float)3.14;
    System.out.println("f3 = " + f3);

    // 실수형 double
    double d1=123.456789;
    System.out.println("d1 = " + d1);

    // 실수형의 강제형변환 : 크기가 같더라도 단위가 다르다.
    float x=15.6f;
    int y=(int)x;
    System.out.println("y = " + y);

    // 문자형 char 2byte --> 정수형 int 4byte
    char r='A';
    int rr=r;
    System.out.println("rr = " + rr);

    //Q. int타입의 정수를 double타입의 실수로 형변환하여 출력하시오.
    // (4바이트) --> (8바이트) : 자동형변환
    int a=5;
    double b=a;
    System.out.println("b = " + b);

    //Q. double타입의 정수를 int타입의 실수로 형변환하여 출력하시오.
    // (8바이트) --> (4바이트) : 강제형변환 필요
    double c=23.6;
    int d=(int)c;
    System.out.println("d = " + d);
  }
}
