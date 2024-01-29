package com.example.part2.ch02;

public class Operator {
  public static void main(String[] args) {
    // 두 과목 점수를 이용하여 총점과 평균을 출력하는 프로그램을 만들어보자.
    int kor, eng, total;
    kor = 77;
    eng = 87;
    total = kor+eng;
    System.out.println("총점="+total);
    System.out.println("평균="+(total/2));
  }
}
