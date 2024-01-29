package com.example.part2.ch03;

public class FindAPI {
  public static void main(String[] args) {
    // 자료형 변수; == 변수 선언
    int a;
    a=10;
    System.out.println("a = " + a);

    // AAA b;

    //"apple" 문자열 저장하고 출력
    // 어딘가에 만들어져 있어 위치를 알려줘야 함. 컴파일 자체 탐색 후 API(클래스들의 집합) 탐색
    // == java.lang.String s; 와 같은 것. 컴파일가 찾아갈 수 있도록 알려준 것. 패키지(폴더)를 생략 가능
    String s;
    s="apple";
    System.out.println("s = " + s);

    // Sting 클래스 안의 메소드를 활용하면 문자열을 조작할 수 있다.
    // 클래스를 사용하는 이유(객체지향), 필요한 API를 언제든지 가져다가 원하는 것을 조작 가능
    System.out.println(s.length());
  }
}
