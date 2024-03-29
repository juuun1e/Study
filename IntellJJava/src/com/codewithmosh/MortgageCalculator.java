package com.codewithmosh;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
  public static void main(String[] args) {
    final byte MONTHS_IN_YEAR = 12; // 12개월 설정
    final byte percent = 100; // 백분율 설정

    int principal = 0;
    float monthlyInterest = 0;
    int numberOfPayments = 0;

    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.print("Princical ($1k - $1M): ");
      principal = sc.nextInt();
      if (principal >= 1000 && principal <= 1_000_000)
        break;
      System.out.println("Enter a number between 1,000 and 1,000,000.");
    }

    while (true) {
      System.out.print("Annual Interest Rate: ");
      float annualInterest = sc.nextFloat(); // 이자율은 작은 숫자이므로 double 대신 float 사용
      if (annualInterest >= 1 && annualInterest <= 30) {
        monthlyInterest = annualInterest / percent / MONTHS_IN_YEAR;
        break;
      }
      System.out.println("Enter a value between 1 and 30.");
    }

    while (true) {
      System.out.print("Period(Years): ");
      byte years = sc.nextByte();
      if (years >= 1 && years <= 30) {
        numberOfPayments = years * MONTHS_IN_YEAR;
        break;
      }
      System.out.println("Enter a value between 1 and 30.");
    }

    double mortgage = principal
        * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
        / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

    String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
    System.out.print("Mortgage: " + mortgageFormatted);
  }

}
