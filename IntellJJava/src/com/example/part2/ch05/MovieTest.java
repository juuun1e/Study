package com.example.part2.ch05;

public class MovieTest {
  public static void main(String[] args) {
    //Q.한 편의 영화 데이터를 저장하고 출력하시오, (조건.class로 Movie 자료형을 모델링할 것)
    Movie m=new Movie();
    m.title="아바타";
    m.openDate="2022.12.24";
    m.actor="Jake selly";
    m.genre="action";
    m.runningTime=192;
    m.limitAge=12;
    System.out.println(m.title+"\t"+m.openDate+"\t"+m.actor+"\t"+m.genre+"\t"+m.runningTime+"\t"+m.limitAge);
  }
}
