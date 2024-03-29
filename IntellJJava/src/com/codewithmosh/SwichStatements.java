package com.codewithmosh;

// switch 조건문 - 마지막 블록은 알아서 빠져나와 breack 필요 없음.
public class SwichStatements {
  public static void main(String[] args) {
    String role = "admin";
    // 정수인 경우 case 1, case 2
    switch (role) {
      case "admin" :
        System.out.println("You're an admin");
        break;

      case "moderator" :
        System.out.println("You're a moderator");
        break;

      default:
      System.out.println("You're a guest");
}

    // if문
/*    String role = " admin";
    if(role == "admin")
      System.out.println("You're an admin");
    else if (role == "moderator")
      System.out.println("You're a moderator");
    else
      System.out.println("You're a guest");*/
  }
}
