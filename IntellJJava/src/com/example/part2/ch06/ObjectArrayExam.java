package com.example.part2.ch06;

import com.example.part2.ch05.Movie;

public class ObjectArrayExam {
  public static void main(String[] args) {
    // Q.[영화 3편]를 저장 할 [배열을 생성]한 뒤 데이터를 저장하고 출력하세요.
    Movie[] mv=new Movie[3];
    mv[0]=new Movie();
    mv[0].limitAge=12;
    mv[0].genre="Action";
    mv[0].runningTime=120;
    mv[0].title="SuperHero";
    mv[0].actor="Superman";
    mv[0].openDate="2024.12.24";

    mv[1]=new Movie();
    mv[1].limitAge=12;
    mv[1].genre="SF";
    mv[1].runningTime=120;
    mv[1].title="아바타";
    mv[1].actor="Jake selly";
    mv[1].openDate="2024.12.24";

    mv[2]=new Movie();
    mv[2].limitAge=12;
    mv[2].genre="Family";
    mv[2].runningTime=120;
    mv[2].title="나 홀로 집에";
    mv[2].actor="Jake";
    mv[2].openDate="2024.12.24";

    for (int i = 0; i <mv.length ; i++) {
      System.out.println(mv[i].title+"\t"+mv[i].openDate+"\t"+mv[i].actor+"\t"+mv[i].genre+"\t"+mv[i].runningTime+"\t"+mv[i].limitAge);
    }
  }
}
