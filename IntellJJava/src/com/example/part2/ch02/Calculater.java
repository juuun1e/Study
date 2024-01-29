package com.example.part2.ch02;

// OOP 객체지향프로그래밍 : 클래스 단위로 코딩을 한다.
// 시작 : 메인클래스
// JavaSE 프로그램 : main을 가지고 있는 클래스로부터 시작하는 프로그램
public class Calculater {

  // 프로그램의 시작을 알리는 시작점 : main(){} 메소드
  // 메소드 : 동작과 처리를 담당
  public static void main(String[] args) {
    // Q. 두 개의 정수를 더하여 출력하는 자바프로그램을 만들어보자.

    // 저장소 변수(변할 수 있는 수) 선언
    // 자료형 : 변수에 어떤 종류의 데이터를 넣을 것인가?에 대한 약속
    int a, b, sum;

    // 정수를 저장소에 할당,대입
    a=1;
    b=3;
    sum = a+b;

    // 출력 : 단축기 sou / sout
    System.out.println(sum);
  }
}
