package com.example.part2.ch06;

import com.example.part2.ch05.Book;

public class ArrayMake {
  public static void main(String[] args) {
    //Q.정수 5개를 저장할 [배열]을 생성하시오. +모든 원소에 10을 저장하시오.
    int[] a=new int[5]; // 배열은 길이가 고정
/*
    a[0]=10;
    a[1]=10;
    a[2]=10;
    a[3]=10;
    a[4]=10;
    System.out.println(a[0]);
    System.out.println(a[1]);
    System.out.println(a[2]);
    System.out.println(a[3]);
    System.out.println(a[4]);
*/
    // 길이가 길어지면 하나하나 주입할 수 없음 => 반복문 사용할 수 있음 : 배열의 장점
    // 반복문(for,while)
    for(int i=0; i<a.length; i++){
      a[i]=10;
      System.out.println(a[i]);
    }


    // 실수 5개 저장할 배열 생성
    float[] f=new float[5];

    // 책 3권을 저장할 배열 생성 : 객체 배열
    Book[] b=new Book[3];
  }
}
