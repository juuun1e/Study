package com.java.grammar;

import java.util.Scanner;

// TODO 요리 레시피 메모장 만들기

//    [ 입력값 ]
//    - 내가 좋아하는 요리 제목을 먼저 입력
//    - 요리 별점을 1~5 사이의 소수점이 있는 실수로 입력(ex. 3.5)
//    - 이어서 내가 좋아하는 요리 레시피를 한 문장씩 10문장을 입력

//    [ 출력값 ]
//    - 입력이 종료되면 요리 제목을 괄호로 감싸서 먼저 출력
//    - 이어서, 요리 별점을 소수점을 제외한 정수로만 출력(ex. 3)
//    - 바로 뒤에 정수 별점을 5점 만점 퍼센트로 표현했을 때 값을 실수로 출력(ex. 60.0%)
//    - 이어서, 입력한 모든 문장 앞에 번호를 붙여서 모두 출력

public class RecipeMemo {
  public static void main(String[] args) {
    // 입력
    Scanner sc = new Scanner(System.in);
    String recipeName = sc.nextLine();
    float score = sc.nextFloat();
    String description1 = sc.nextLine();
    String description2 = sc.nextLine();
    String description3 = sc.nextLine();
    String description4 = sc.nextLine();
    String description5 = sc.nextLine();
    String description6 = sc.nextLine();
    String description7 = sc.nextLine();
    String description8 = sc.nextLine();
    String description9 = sc.nextLine();
    String description10 = sc.nextLine();

    // 요리 별점 형변환
    int intScore = (int)score;
    // 5점 만점 퍼센트로 표현
    double percenttage = intScore * 100 / 5.0;


    // 출력
    System.out.println("[ " + recipeName + " ]");
    System.out.println("별점 : " + intScore + " (" + percenttage + "%)");
    System.out.println("1. " + description1);
    System.out.println("2. " + description2);
    System.out.println("3. " + description3);
    System.out.println("4. " + description4);
    System.out.println("5. " + description5);
    System.out.println("6. " + description6);
    System.out.println("7. " + description7);
    System.out.println("8. " + description8);
    System.out.println("9. " + description9);
    System.out.println("10. " + description10);
  }

}
