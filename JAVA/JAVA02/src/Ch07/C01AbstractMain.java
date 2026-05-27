package Ch07;


// 일반클래스 상속관계
class Parent1 {
	//
	void func() {}
}

class Son1 extends Parent1 {
	void func() {System.out.println("Son1's 에서 재정의한 func...");}
}

// 추상클래스 상속관계
abstract class Parent2 { //구현을 미루고 설계부터하기 위한 클래스
						 //미완성되어있는 클래스 객체 생성을 할 수 없다.
	
	abstract void func(); 
}

class Son2 extends Parent2
{

	@Override
	void func() {
		System.out.println("Son2's 에서 재정의한 func...");
		
	}

}

class Son3 extends Parent2 {

	@Override
	void func() {
		System.out.println("Son3's 에서 재정의한 func...");
		
	}
	
}

public class C01AbstractMain {

	public static void main(String[] args) {
		// 일반클래스 간 상속관계
//		Parent1 ob1 = new Parent1(); // 상위클래스형 객체 생성 o
//		Son1 ob2 = new Son1(); 		 // 하위클래스형 객체 생성 o
//		Parent1 ob3 = new Son1();	 // UPCASTING 연결 o
//		ob3.func();					 // 재정의된 func() 접근 o
		
		
		// 추상클래스 상속관계			   // 추상메서드 사용 강제성 부여!
		//Parent2 ob4 = new Parent2(); // 상위클래스형 객체 생성 x
		Son2 ob5 = new Son2();		   // 하위클래스형 객체 생성 o(단, 상위클래스의 추상메서드를 재정의 해야 객체 생성 가능)
		Parent2 ob6 = new Son2();	   // UPCASTING 연결 o
		ob6.func();					   // 재정의된 func() 접근 o
		
		ob6 = new Son3();
		ob6.func();
		
		
		
		
		
		
		
	}

}
