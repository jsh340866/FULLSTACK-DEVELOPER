package Ch01;

class C02Person {
	//속성(멤버변수,필드)
	public String name;		// null(기본값)
	public int age;				// 0(기본값) 			//false '0'값
	public float height;	// 0.0F(기본값)
	public double weight;	// 0.0(기본값)
	
	//기능(메서드,함수..)+
}


public class C02PersonMain {

	public static void main(String[] args) {
		C02Person hong = new C02Person();
		hong.name="홍길동";
		hong.age=15;
		hong.height=177.5f;
		hong.weight=70.5;
		System.out.printf("%s %d %f %f\n", hong.name,hong.age,hong.height,hong.weight);

	}

}
