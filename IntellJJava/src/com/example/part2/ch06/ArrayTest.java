package com.example.part2.ch06;

public class ArrayTest {
  public static void main(String[] args) {
    // Q.[실수 5개]를 저장 할 [배열을 생성]한 뒤 모든 원소에 10.5을 저장하고 출력하세요.
    float[] f= new float[5];
    for(int i=0; i<f.length; i++){
      f[i]=10.5f;
      System.out.println(f[i]);
    }

    // 기억공간이 만들어짐과 동시에 값을 저장하는 것 : {초기화} ...
    // Q.정수 5개를 배열에 초기화하고 index 0번째와 index 3번째 값을 더하여 출력하세요.
    int[]a={10,20,30,40,50};
    for (int i = 0; i < a.length; i++) {
      System.out.println(a[i]);
    }
    int sum=a[0]+a[3];
    System.out.println("sum = " + sum);
    System.out.println(a.length);

    // 배열 생성하고 값을 안넣어도 int의 기본값인 0이 세팅되어 있음. float라면 0.0
    int[] b = new int[3];
    System.out.println(b[0]);
    System.out.println(b[1]);
    System.out.println(b[2]);

    // 초기화 두 줄로 하고 싶다면? 꼭 생성자!!
    int[]c;
    c=new int[]{10,20,30,40,50};

  }
}
