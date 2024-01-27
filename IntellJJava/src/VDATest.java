public class VDATest {
  public static void main(String[] args) {
    // Q. 정수 한 개를 저장하기 위해 [변수를 선언]하시오.
    int a; // 변수선언 -> 메모리에 기억공간의 생성
    a=10;  // 변수할당
    System.out.println("a = " + a);
    
    // Q. 저장된 값을 변수 b에 저장하고 변수 b에 10을 곱하여 c에 저장하시오. 
    // int a = 10; // 변수 초기화(변수+할당, 연산가능)
    int b=a;
    int c=b*10;
    System.out.println("c = " + c);
    
    // Q. sum이라는 변수에 1부터 5까지의 수를 누적해서 출력하시오.
    int sum=0; // 지역변수 : 메소드 안에서 만들어지는 변수, 반드시 초기화하여 사용해야 한다.
    sum=sum+1; // 0+1
    sum=sum+2; // 1+2
    sum=sum+3; // 3+3  => sum=sum+i 의 규칙 => 반복문(for, while)
    sum=sum+4; // 6+4
    sum=sum+5; // 10+5
    System.out.println("sum = " + sum);

    // Q. x=10, y=20을 저장하고 변수의 값을 서로 교환(swap)하여 출력하시오.
    int x=10;
    int y=20;
    int tmp;
    System.out.println("x = " + x + " : " + "y = " + y);

    tmp=y;
    y=x;
    x=tmp;
    System.out.println("x = " + x + " : " + "y = " + y);

  }
}
