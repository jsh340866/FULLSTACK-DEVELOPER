package Ch01;

// 생성자 메서드

// ex) Scanner sc = new Scanner(System.in)
// 생성자 메서드 위치 : Scanner(System.in)
// 
// 객체 생성시 1회만 호출되는 메서드
// 생성된 객체 내에서는 사용이 불가능
// 객체 생성시에 필요한 메모리 공간 형성과 '초기값 부여'에 사용
// (중요)생성자 메서드의 이름은 클래스이름과 동일하게 부여
// 생성자 메서드는 반환자료형을 가지지 않는다
//
// 생성자 함수를 클래스 내에 명시하지 않으면(코드삽입x)
// 컴파일러에 의해 기본 생성자 함수가 주입된다(디폴트 생성자)
// 클래스 내에 생성자함수를 명시하면(코드삽입o)
// 디폴트 생성자는 주입되지 않는다.

class C08Simple {
	// 속성
	int n1;
	double n2;
	boolean n3;
	String n4;

	// 기능

	// 생성자(Constructor)
	C08Simple() {
		System.out.println("C08Simple()");
		this.n1 = 11;
		this.n2 = 22.22;
		this.n3 = true;
		this.n4 = "HELLO WORLD";

	}

//	C08Simple(int n1,double n2,boolean n3, String n4) {
//		System.out.println("C08Simple(int n1,double n2,boolean n3, String n4)");
//		this.n1 = n1;
//		this.n2 = n2;
//		this.n3 = n3;
//		this.n4 = n4;
//	}

	public C08Simple(int n1, double n2, boolean n3, String n4) {
		super();
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
		this.n4 = n4;
	}

	public C08Simple(int n1, double n2, boolean n3) {
		super();
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
	}

	public C08Simple(int n1, double n2) {
		super();
		this.n1 = n1;
		this.n2 = n2;
	}

	public C08Simple(int n1) {
		super();
		this.n1 = n1;
	}

	// toString재정의
	@Override
	public String toString() {
		
		return "C08Simple [n1=" + n1 + ", n2=" + n2 + ", n3=" + n3 + ", n4=" + n4 + "]";
	}

}

public class C08ConstructorMain {

	public static void main(String[] args) {
		C08Simple ob1 = new C08Simple();
		System.out.println(ob1);
		System.out.println("----------------------------");
		C08Simple ob2 = new C08Simple(10, 20.2, true, "TEST");
		System.out.println(ob2);

	}

}
