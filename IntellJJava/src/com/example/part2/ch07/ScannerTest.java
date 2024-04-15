package com.example.part2.ch07;

import java.util.Scanner;

public class ScannerTest {
  public static void main(String[] args) {
    // 키보드로부터 데이터 입력받기
    Scanner sc = new Scanner(System.in);

    System.out.print("정수를 입력해주세요 : ");
    int num = sc.nextInt(); // 블럭상태
    System.out.println("num = " + num + "\n");

    System.out.print("실수를 입력해주세요 : ");
    float f = sc.nextFloat(); // 블럭상태
    System.out.println("f = " + f + "\n");

    System.out.print("문자열을 입력해주세요 : ");
    String word = sc.next();
    System.out.println("word = " + word + "\n");

    sc.nextLine(); // 버퍼비우기, 스트림 비우기

    System.out.print("문자열을 입력해주세요 : ");
    String content = sc.nextLine();
    System.out.println("content = " + content + "\n");

    sc.close();
  }
}
