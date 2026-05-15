package Ch16;

import java.util.ArrayList;

//(1) 문자열 -> 정수변환
interface StrToInt {
	int convert(String s);
}
//(2) 문자열을 받아 출력만 (반환 없음)
interface StrConsumer {
	void accept(String s);
}
//(2) 테스트 클래스
class C04Person {
	String name;
	int age;
	
	C04Person(){}
	C04Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	static void print(String s) {
		System.out.println("Person's print : " + s);
	}
	@Override
	public String toString() {
		return "C04Person [name=" + name + ", age=" + age + "]";
	}
	
}
//(3) 문자열 -> 변형된 문자열 변환
interface StrToStr {
	String apply(String s);
}
//(4) 두 문자열 비교 -> 정수 결과
interface PersonFactory {
	C04Person create();
}
interface PersonFactory2 {
	C04Person create(String name, int age);
}
interface ListFactory {
	ArrayList<String> create();
}

public class C04MethodReferenceMain {

	// 정적 메서드 참조 실습용
	public static int toLength(String s) {
		return s.length();
	}

	public static void main(String[] args) {
		//(1) 문자열 -> 정수변환
		StrToInt t1 = s -> Integer.parseInt(s);	// 람다
		StrToInt t2 = Integer::parseInt;	// 매서드참조형(::)
		StrToInt t3 = C04MethodReferenceMain::toLength;
		
		System.out.println("(1-1) 람다      : " + t1.convert("123"));
		System.out.println("(1-2) 메서드 참조 : " + t2.convert("456"));
		System.out.println("(1-3) 메서드 참조(기존 함수) : " + t3.convert("https"));
		toLength("https");
		System.out.println("------------------------------");
		
		//(2) 문자열을 받아 출력만 (반환 없음)
		StrConsumer t4 = (s) -> {System.out.println(s);};
		StrConsumer t5 = System.out::println;
//		StrConsumer t6 = (s)->{C04Person.print(s);};
		StrConsumer t6 = C04Person::print;
		
		t4.accept("(2-1) HELLO WOLRD1");
		t5.accept("(2-2) HELLO WOLRD2");
		t6.accept("(2-3) HELLO WOLRD2");
		System.out.println("------------------------------");
		
		//(3) 문자열 -> 변형된 문자열 반환
		StrToStr t7 = (s)->{return s.toUpperCase();};
		StrToStr t8 = String::toUpperCase;
		
		System.out.println("(3-1) : " + t7.apply("apple"));
		System.out.println("(3-2) : " + t8.apply("apple"));
		System.out.println("------------------------------");
		
		//(4) 두 문자열 비교 -> 정수 결과
		PersonFactory t9 = ()->{return new C04Person();};
		PersonFactory t10 = C04Person::new;
		PersonFactory2 t11 = C04Person::new;
		
		System.out.println(t9.create());
		System.out.println(t10.create());
		System.out.println(t11.create("홍길동",11));
		
		ListFactory t12 = ()->{return new ArrayList<>();};
		ListFactory t13 = ArrayList::new;
		
		
	}

}
