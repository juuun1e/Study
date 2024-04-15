package com.example.part2.ch06;

public class TwoDimArrayTest {
  public static void main(String[] args) {
    // 행(row)과 열(column)로 데이터 저장하기(2차원 배열, 테이블구조, 행렬)
    // Q.2행 4열의 [정수형] [배열을 생성]하세요.
    int[][] a = new int[2][4];
    a[0][0] = 10;
    a[0][1] = 20;
    a[0][2] = 30;
    a[0][3] = 40;

    a[1][0] = 50;
    a[1][1] = 60;
    a[1][2] = 70;
    a[1][3] = 80;

    System.out.println(a[0][0] + "\t" + a[0][1] + "\t" + a[0][2] + "\t" + a[0][3]);
    System.out.println(a[1][0] + "\t" + a[1][1] + "\t" + a[1][2] + "\t" + a[1][3]);
  }
}
