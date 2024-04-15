package com.example.part2.ch07;

import java.util.Scanner;

public class ScannerExam {
  public static void main(String[] args) {
    // 도서 정보 입력받기
    Scanner sc = new Scanner(System.in);

    System.out.print("제목을 입력해주세요 : ");
    String title = sc.nextLine(); // 블럭상태 : 잠깐 멈춰있는 상태
    System.out.println("제목 : " + title + "\n");


    System.out.print("가격을 입력해주세요 : ");
    int price = sc.nextInt();
    System.out.println("가격 : " + price + "\n");

    sc.nextLine();

    System.out.print("출판사를 입력해주세요 : ");
    String company = sc.nextLine();
    System.out.println("출판사 : " + company + "\n");


    System.out.print("저자를 입력해주세요 : ");
    String writer = sc.nextLine();
    System.out.println("저자 : " + writer + "\n");

    System.out.print("총 페이지 수를 입력해주세요 : ");
    int totalPages = sc.nextInt();
    System.out.println("페이지 : " + totalPages + "\n");

    sc.nextLine();

    System.out.print("상품 번호를 입력해주세요 : ");
    String productNumber = sc.nextLine();
    System.out.println("상품번호 : " + productNumber + "\n");

    System.out.println("제목:" + title + "  가격:" + price + "  출판사:" + company + "  저자:" + writer + "  페이지:" + totalPages + "  상품번호:" + productNumber);

  }
}
