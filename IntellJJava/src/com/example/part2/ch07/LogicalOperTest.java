package com.example.part2.ch07;

public class LogicalOperTest {
  public static void main(String[] args) {
    // Q. 논리연산자의 결과 값
    int x=1, y=0;
    System.out.println(!(x>0));          // false
    System.out.println(x>0 && x<3);      // true
    System.out.println(x>0 && y<0);      // f
    System.out.println(x<0 || y>=0);     // t
    System.out.println(y<0 && y<-5);     // f

    System.out.println();
    
    int a=3,b=5;
    System.out.println( (a>3) && (b<6));  // f
    System.out.println( (a!=3) && (a>2)); // f
    System.out.println( (b!=5) || (a==1));// f
  }
}
