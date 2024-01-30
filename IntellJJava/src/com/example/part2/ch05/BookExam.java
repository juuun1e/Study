package com.example.part2.ch05;

//Q. 저번 시간에 만들어 놓은 Book자료형을 이용하여 책 정보를 저장하고 출력하시오.
public class BookExam {
  public static void main(String[] args) {
    //정수 1개를 저장할 변수를 선언하시오.
    int a;
    a=10;

    //책 한 권을 저장할 변수를 선언하시오.
    // Book b;
    // b=new Book();

    //한 권의 책 데이터를 저장하기 위해 객체를 생성하시오.(=인스턴스를 만드시오.)
    Book b = new Book();
    b.title="자바";
    b.author="박매일";
    b.company="패스트캠퍼스";
    b.price=30000;
    b.page=700;
    b.isbn="1199110";
    System.out.println(b.title + "\t" + b.author + "\t" + b.company + "\t" + b.price + "\t" + b.page + "\t" + b.isbn);
  }
}
