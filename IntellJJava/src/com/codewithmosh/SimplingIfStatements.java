package com.codewithmosh;
// if 조건문의 단순화
public class SimplingIfStatements {
  public static void main(String[] args) {
    int income = 120_000;
    boolean hasHighIncome = (income > 100_000);
/*    boolean hasHighIncome;

    if (income > 100_000)
      hasHighIncome = true;
    else
      hasHighIncome = false;*/

    System.out.println(hasHighIncome);

  }
}
