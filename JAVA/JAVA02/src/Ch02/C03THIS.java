package Ch02;


// this
// 클래스 내에서 사용되는 예약어
// 생성되는 객체의 위치정보(메모리주소 - 해시코드 값)을 확인하는데 사용

// this.멤버변수명 		: 멤버변수와 지역변수 구별에 사용
// this() 				: 오버로딩된 다른 생성자 호출 사용

class C03Simple
{
	// 속성
	int x;
	int y;
	
	// 디폴트
	public C03Simple() {
//		this.x=10;
//		this.y=10;
		this(10,10);
		System.out.println("C03Simple() 호출!");
	}
	
	// x만
	public C03Simple(int x) {
//		this.x=x;
//		this.y=10;
		this(x,10);
		System.out.println("C03Simple(int x) 호출!");
	
	}
	
	// x,y둘다
	public C03Simple(int x, int y) {
		this.x=x;
		this.y=y;
		System.out.println("C03Simple(int x, int y) 호출!");
	}
	
	// 기능
	public C03Simple getThis() {
		return this;
	}

	@Override
	public String toString() {
		return "C03Simple [x=" + x + ", y=" + y + "]";
	}

}


public class C03THIS {

	public static void main(String[] args) {
			C03Simple ob1 = new C03Simple();
//			System.out.println("ob1 : " + ob1);
//			System.out.println("ob1 : " + ob1.getThis());
			System.out.println("----------------");
			C03Simple ob2 = new C03Simple(11);
			System.out.println("----------------");
			C03Simple ob3 = new C03Simple(22,33);
			System.out.println("----------------");
			System.out.println(ob1);
			System.out.println(ob2);
			System.out.println(ob3);
			
			
			
	}

}
