package Ch04;

// static : 공유 메모리(클래스==메서드)에 변수/메서드 적재,
// 			객체 생성과는 무관하게 공간 할당, 클래스명 접근가능

class C01Simple {
	static int n1;
	int n2;
	
	//디폴트생성자
	public C01Simple() {
		super();
	}
	//모든 인자 생성자
	public C01Simple(int n1, int n2) {
		super();
		this.n1 = n1;
		this.n2 = n2;
	}
	//toString
	@Override
	public String toString() {
		return "C01Simple [n1=" + n1 + ", n2=" + n2 + "]";
	}
	
}


public class C01StaticMain {

	public static void main(String[] args) {
		
		//C01Simple.n2 = 100;
		C01Simple.n1 = 1234;
		
		C01Simple ob1 = new C01Simple();
		C01Simple ob2 = new C01Simple();
		
		System.out.println("ob1 : " + ob1);
		System.out.println("ob2 : " + ob2);
		System.out.println("----------------------");
		ob1.n1 = 2323;
		System.out.println("ob1 : " + ob1);
		System.out.println("ob2 : " + ob2);
		ob2.n1 = 5567567;
		System.out.println("ob1 : " + ob1);
		System.out.println("ob2 : " + ob2);
	}

}
