package Ch01;

public class C00INFO {

	public static void main(String[] args) {
		
		// 1. 객체란(OBJECT)?
		// 존재(독점적이고 배타적인 공간(VOLUMN)을 차지) 사물(OBJECT) 
		
		// 2. 객체 구조
		// 속성(Attribute)		: 객체마다 구별되는 데이터(저장의 대상 - 변수 처리) 
		// 기능(Function)			: 객체가 수행할 수 있는 공통 ACTION(처리로직 - 매서드(함수))
		
		// 3. 객체 지향?
		// 현실 세계의 여러 객체 정보(속성/기능) 중에 문제 해결을 위해 필요한 
		// 일부만 추출(추상화)하여 JAVA 프로그램 내의 메모리 공간에 적재(저장)하기
		// 위해 고안한 문법 체계
		
		// 4. 클래스?
		// 동일한 종류의 객체에 필요한 메모리공간을 제거하기 위해 선언된 자료형
		// 클래스로 객체를 생성하기 전에는 기본적으로 메모리공간을 차지하지 않는다.
		// (예외. 자바의 Reflection으로 클래스문서를 통한 객체생성가능(.class))
		// 클래스 자료혀에 의해 객체가 정의되는 순간 클래스에서 선언한 속성과 기능대로 
		// 공간형성이 이루어진다.
		
		// 5. 자바의 메모리 영역
		// 1) 스택영역						: {} 내에서 생성되고 소명되는 영역(int, double...)
		// 2) 클래스(==메서드)영역	: 공유메모리 영역(생성자, 일반메서드, static메서드, static변수)
		// 3) 힙영역 						: 객체 저장 영역(new 예약어 사용시 할당)
		
		// ex) Scanner sc = 1)new 2)Scanner(System.in);
		//	public class Ex00{
		//	public static void main(String [] args)
		//	{
		//		Scanner sc = new Scanner(System.in);
		//	}
		
		// new								: C++ 힙(Heap) 영역에 객체 저장 // 힙 영역에 쓰겠다! 선언
		// Scanner(System.in)	: 생성자 함수 호출(객체 생성에 필요한 초기값 부여, size전달)
		// Scanner sc					: Scanner라는 클래스 자료형으로 정의된 참조변수 sc(Main Stack)
		
		// 힙메모리 영역에 Scanner 객체 생성에 필요한 초기값을 부여해 객체 생성을 한뒤
		// main stack 내의 Scanner 자료형으로 만든 sc 참조변수에 생성되어진 Scanner 객체의
		// "시작 메모리 주소값"을 저장
		
		
		
		
		
		
		
	}

}
