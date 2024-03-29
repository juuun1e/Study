package com.codewithmosh;

import java.util.Scanner;

// do-while loops : 조건이 f인 경우에도 항상 적어도 한 번 실행
// 대부분의 경우 while문의 사용을 더 선호
public class DoWhileLoops {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String input = "";

    do {
      System.out.print("Input: ");
      input = sc.next().toLowerCase();
      System.out.println(input);
    } while (!input.equals("quit"));
  }
}
