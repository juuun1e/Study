public class CarTest {
  public static void main(String[] args) {
    // java API(External Lib)에 있는 String 자료형 = "문자열"
    String model="BMW528i";
    System.out.println("model = " + model);

    //100000 -> int(4byte)로 인식 뒤에 L을 붙여주면 long(8byte)로 인식해서 더 큰 숫자 표현 가능
    long distance=100000L;
    System.out.println("distance = " + distance +"km");

    int price=9000000;
    System.out.println("price = " + price);

    char type='A';
    System.out.println("type = " + type + "Type");

    boolean auto=true;
    System.out.println("auto = " + auto);

    int year=2000;
    System.out.println("year = " + year);

    String company="BMW";
    System.out.println("company = " + company);

    // 소수점 기본은 정밀도를 표현해주는 double(8byte)로 인식. float로 인식하게 하기 위해서는 뒤에 f 붙여줄 것
    float gasmi=12.5f;
    System.out.println("gasmi = " + gasmi +"l");
  }
}
