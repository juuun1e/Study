package com.codewithmosh;

import java.util.Scanner;

public class BreakandContinue {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String input ="";

    // quit으로 종료해도 "quit"을 한 번 반환하고 끝내는 문제
    // 해결 2 : break문
    while (true) { // ture -> 사용자가 종료할 때까지 영원히 실행됨
      System.out.print("Input: ");
      input = sc.next().toLowerCase();
      if(input.equals("pass"))
        continue; // 루프의 시작 부분으로 이동
      if(input.equals("quit"))
        break; // 곧바로 종료
      System.out.println(input);
    }

    // 해결 1 : if문
    while (!input.equals("quit")){
      System.out.print("Input: ");
      input = sc.next().toLowerCase();
      if(!input.equals("quit"))
        System.out.println(input);
    }
  }
}
