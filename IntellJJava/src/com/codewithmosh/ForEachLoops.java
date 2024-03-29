package com.codewithmosh;

public class ForEachLoops {
  public static void main(String[] args) {
    String[] fruits = { "Apple", "Mango", "Orange" };

    for (int i = 0; i < fruits.length; i++)
      System.out.println(fruits[i]);

    // for-each문 = 항상 정방향으로만 진행 - 역순 표현 불가, 인덱스 접근 불가
    for (String fruit : fruits)
      System.out.println(fruit);
  }
}
