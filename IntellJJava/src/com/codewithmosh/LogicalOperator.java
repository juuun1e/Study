package com.codewithmosh;

// TODO 논리연산자 &&(AND) - 앞의 조건이 거짓이면 뒤 상관없이 거짓
public class LogicalOperator {
  public static void main(String[] args) {
    int temprerature = 22;
    boolean isWarm = temprerature > 20 && temprerature < 30;
    System.out.println(isWarm);

// TODO 논리연산자 ||(OR) - 최소 하나의 조건이 같으면 참
    boolean hasHighIncome = false;
    boolean hasGoodCredit = true;
    boolean hasCriminalRecode = false;
    boolean isEligible = (hasHighIncome || hasGoodCredit) && !hasCriminalRecode;
    System.out.println(isEligible);
  }
}
