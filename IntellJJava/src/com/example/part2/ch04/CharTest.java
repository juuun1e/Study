package com.example.part2.ch04;

public class CharTest {
  public static void main(String[] args) {
    // Q. '가'라는 한글 한 문자(수치형자료)를 변수에 저장하고 출력하시오.
    char ga = '가';
    System.out.println("ga = " + ga);

    int ka = '가';
    System.out.println("ka = " + ka);

    int gaka = '\uAC00';
    System.out.println("gaka = " + gaka);

    // 형변환 casting
    int b ='B'+1;
    System.out.println("b = " + b);
    System.out.println("b = " + (char)b);


    // Q. 대문자 'A'를 문자 'a'로 변환하여 출력하시오.
    char upper = 'A';
    char lower = (char)(upper+32);
    System.out.println("lower = " + lower);

    char low = 'b';
    char upp = (char)(low-32);
    System.out.println("upp = " + upp);


    // Q. '1'+'2'='3'이 나오도록 프로그래밍 하시오.
    char one ='1';
    char two ='2';
    int sum = (one-48) + (two-48);
    //int sum = (one-'0') + (two-'0');
    System.out.println("sum = " + sum);

  }
}
