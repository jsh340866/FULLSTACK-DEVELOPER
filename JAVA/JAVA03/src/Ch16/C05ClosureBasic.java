package Ch16;

interface Greeter {
	String say();
}


public class C05ClosureBasic {

	//
	private static Greeter makeGreeter(String name) {
		return ()->{return "Closure : " + name;};
	}
	
	public static void main(String[] args) {
		// 1 외부 변수 캡처 - 
		String str = "Hello?";
		Greeter t1 = ()->{return str;};
		System.out.println("1. " + t1.say());
		
		// 2 외부 변수 캡처
		int n = 100;
		Greeter t2 = ()->{return "2. " + n;};	// n -> final 지정 // 외부변수 참조할 때는 참조값이 final 이 된다.
//		n = 200;
		System.out.println(t2.say());
		
		// 3
		Greeter t3 = makeGreeter("hihi");
		Greeter t4 = makeGreeter("hello hello");
		
		// 4
		System.out.println(t3.say());
		System.out.println(t4.say());
		
		
	}

}
