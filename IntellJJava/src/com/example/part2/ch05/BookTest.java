package com.example.part2.ch05;

public class BookTest {
  public static void main(String[] args) {
    //Q. [정수] 한 개를 저장하는 [변수를 선언]하시오.
    int a;

    //Q. 한 권의 책 데이터를 저장하고출력하시오.(6개 변수)
    //변수 개별적, 한 권의 책이라고 볼 수 있는가
    String title="java";
    int price=28000;
    String company="fastcampus";
    String author="박자바";
    int page=687;
    String isbn="ISBN-111990011";
    System.out.println(title+"\t"+price+"\t"+company+"\t"+author+"\t"+page+"\t"+isbn);

    //Q. 6개의 변수를 하나의 구조에 담기 위해 Book이라는 바구니(이동)을 만들어보시오.
    //Q. [책] 한 권을 저장하는 [변수를 선언]하시오. --> 기본 자료형이 없으니까 만들어야 함
    Book b; // b라는 기억공간이 만들어짐, Book의 구조 : 6개의 변수 덩어리,객체
    b =new Book(); // 객체생성

  }
}
