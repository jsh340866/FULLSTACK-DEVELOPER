package Ch05;


class Parent{
	void func1() {System.out.println("Parent's func1() Call!");}
	void func2() {System.out.println("Parent's func2() Call!");}
}
class Son extends Parent {
	//재정의
	void func2() {System.out.println("Son's func2() Call!");}
	
	//추가(확장)
	void func3() {System.out.println("Son's func3() Call!");}
	
}

public class C08UpDownCastingMain {

	public static void main(String[] args) {
		//NoCasting
//		Parent ob1 = new Parent();
//		ob1.func1();
//		ob1.func2();
//		System.out.println("-----------------");
//		Son ob2 = new Son();
//		ob2.func1();
//		ob2.func2();
//		ob2.func3();
//		System.out.println("-----------------");
		
		//UpCasting
		Parent ob3 = new Son();
		ob3.func1();
		ob3.func2();
		
		//UPCASTING된 상태(상위클래스형 참조변수 = 하위클래스형 객체)에서
		//상위클래스형 참조변수는 연결된 하위클래스형 객체의 추가된 멤버에 접근이 가능하다? x -> DownCasting 필요
		//상위클래스형 참조변수는 연결된 하위클래스형 객체의 재정의된 멤버매서드에 접근이 가능하다? o 
		
		
		
		
		
		
		
		
		
		
		

	}

}
