package Ch16;


interface Printer {
//	void print(String name);	// 01 추상메서드
	String print(String name);	// 02 추상메서드
}


public class C02Lamda중요 {

	public static void main(String[] args) {
		// 01	
		// 인터페이스를 바로 연결해 객체를 만들고 추상메서드를 완성하는게 람다식
		// 단 인터페이스에 하나의 메서드만 있어야함
//		Printer printer = (name)->{System.out.println("01 " + name);};
//		Printer printer = System.out::println;
//		printer.print("HELLO WORLD");
		
		// 02	// return 값이 필요한 경우
		Printer printer = (name)->{return "02 " + name;};
		String str2 = printer.print("HELLO WORLD");
		System.out.println(str2); 

	}

}
