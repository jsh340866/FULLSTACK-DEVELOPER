package Ch01;

class C03Person {
	//속성(멤버변수,필드)
	public String name;		// null(기본값)
	public int age;				// 0(기본값) 			//false '0'값
	public float height;	// 0.0F(기본값)
	public double weight;	// 0.0(기본값)
	
	//기능(메서드,함수..)
	void talk() {System.out.printf("%s님이 말합니다.\n",this.name);}
	void walk() {System.out.printf("%s님이 걷습니다.\n",this.name);}
	String ShowInfo() {
		return "name : " + this.name + 
					 " age : " + this.age +
					 " height : " + this.height +
					 " weight : " + this.weight;
	}
	@Override
	public String toString() {
		return "C03Person [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + "]";
	}
	
	
}


public class C03PersonMain {

	public static void main(String[] args) {
		C03Person hong = new C03Person();
		//속성 저장
		hong.name="홍길동";
		hong.age=15;
		hong.height=177.5f;
		hong.weight=70.5;
		
		//기능 사용
		hong.talk();
		hong.walk();
		hong.ShowInfo();
		System.out.println(hong.ShowInfo());
		//toString 사용해서 객체속성정보 확인
		System.out.println(hong.toString());
	}

}
