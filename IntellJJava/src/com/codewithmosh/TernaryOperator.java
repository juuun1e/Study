package com.codewithmosh;
// 삼항 연산자 - 조건 ? 참V1 : 거짓V2
public class TernaryOperator {
  public static void main(String[] args) {
    int income = 120_000; // 조건이 참이면 ?
    String className = (income > 100_000) ? "Frist" : "Economy";
    System.out.println("Class Name is " + className);

/* 2 :
    String className = "Economy";

    if(income > 100_000)
      className = "First;";
    */

/* 1:
    String className;

    if(income > 100_000)
      className = "First;";
    else
      className = "Economy";*/
  }
}
