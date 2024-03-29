package com.codewithmosh;

import java.util.Scanner;

// while문 : 몇번 반복해야 하는지 정보가 없을 때
public class whileLoops {
  public static void main(String[] args) {
    int i = 0;
    while (i > 0){
      System.out.println("Hello World"+i);
      i--;
    }

    // 스캐너 객체는 while문 밖에서 미리 생성 : 메모리 관리
    Scanner sc = new Scanner(System.in);
    String input ="";
    // 참조유형의 데이터 비교는 비교연산자가 아닌 .equals 메서드 사용
    while (!input.equals("quit")){
      System.out.print("Input: ");
      //quit를 대문자로 작성할 경우를 대비하여 소문자로 변환시켜 할당
      input = sc.next().toLowerCase();
      System.out.println(input);
    }
  }
}
