package com.example.part2.ch06;

public class ArraryBasicTest {

  public static void main(String[] args) {
    //Q.정수 3개를 저장할 변수를 선언하고 모두 10을 저장하세요.
    //불연속적, 개별로 기억공간 생성했을 때 발생되는 문제 : 데이터 수가 늘어나면 핸들링 어려워짐
    //비효율적, 데이터 처리 복잡(인덱스 번호 부여를 못해서 반복문 사용 불가), 데이터 이동 어려움
    int a, b, c;
    a=10;
    b=10;
    c=10;
    int sum = a + b + c;
    System.out.println("sum = " + sum);
  }
}
