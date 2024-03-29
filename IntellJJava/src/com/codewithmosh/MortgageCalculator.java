package com.codewithmosh;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
  public static void main(String[] args) {
    final byte MONTHS_IN_YEAR = 12; // 12개월 설정
    final byte percent = 100; // 백분율 설정

    Scanner sc = new Scanner(System.in);

    System.out.print("Princical: ");
    int principal = sc.nextInt();

    System.out.print("Annual Interest Rate: ");
    float annualInterest = sc.nextFloat(); // 이자율은 작은 숫자이므로 double 대신 float 사용
    float monthlyInterest = annualInterest / percent / MONTHS_IN_YEAR;
    // 숫자로만 넣으면 다른 사람이 이해하기 힘들기 때문에 상단에 상수로 정해 선언
    // m1 m2 와 같은 변수 이름은 지양. 항상 의미있고 설명이 포함된 이름을 사용하기

    System.out.print("Period(Years): ");
    byte years = sc.nextByte();
    int numberOfPayments = years * MONTHS_IN_YEAR;

    double mortgage = principal
                * (monthlyInterest * Math.pow(1+monthlyInterest,numberOfPayments))
                / (Math.pow(1+monthlyInterest,numberOfPayments)-1);

    String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
    System.out.print("Mortgage: " + mortgageFormatted);
  }
}
