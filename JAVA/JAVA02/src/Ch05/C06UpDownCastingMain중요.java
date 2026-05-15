package Ch05;


class Super{
	int n1;
}
class Sub extends Super {
	int n2;
}


public class C06UpDownCastingMain중요 {

	public static void main(String[] args) {
		//Casting : 클래스 형변환
		
		//NoCasting : 형변환 x
		Super ob1 = new Super();
		ob1.n1 = 10;
		
		Sub ob2 = new Sub();
		ob2.n1 = 10;
		ob2.n2 = 20;
		
		//Upcasting[★★★★★]  : 상위클래스형 참조변수 = 하위클래스형 객체
		//				     : 자동형변환(메모리 영역의 침범우려 우려가 없기 때문에)
		//이유				 : 1) !상속관계로 구성된 모든 하위객체를 연결할 수 있다.
		//					 : 2) !Upcasting된 상태에서는 재정의된 메서드에 접근 가능하다.
		
		Super ob3 = new Sub(); //UPCASTING // 자동형 변환 (Super)new Sub(); 
		ob3.n1=10;
		//ob3.n2=20; // 접근 불가 // x
		
		Super ob4 = ob2;	   // UPCASTING
		ob4.n1=100;
		//ob4.n2=200; // 접근 불가 // x
		
		
		//Downcasting[★★★★] : 하위클래스형 참조변수 = 상위클래스형 객체
		// 					 : 강제형변환
		//					 : Upcasting을 전제해로 작업을 진행하는 경우가 많다.
		
//		Sub ob5 = (Sub)new Super();
//		ob5.n1 = 100;
//		ob5.n2 = 200;
		
		Sub down = (Sub)ob4;		//
		down.n1=100;
		down.n2=200;
		
	}

}
