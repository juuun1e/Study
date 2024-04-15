package com.example.part2.ch07;

public class AssignOperTest {
  public static void main(String[] args) {
    // 1씩 증가하는 수식 표현
    int a = 1;
    a++; // 1 출력, 저장된 값은 2
    ++a; // 3 출력 및 저장
    a = a+1; // 4 출력 및 저장
    a+=1; // 4+1 = 5
    System.out.println(a); //5

    System.out.println();

    // 1씩 감소하는 수식 표현
    int b = 7;
    b--; // 7 출력, 저장된 값은 6
    --b; // 5 출력 및 저장
    b = b - 1; // 4 출력 및 저장
    b -=1; // 4-1 = 3
    System.out.println(b); //3
  }
}
