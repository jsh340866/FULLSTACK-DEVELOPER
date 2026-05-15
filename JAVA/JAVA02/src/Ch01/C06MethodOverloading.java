package Ch01;

import java.util.Scanner;

class Cal2{
	// 속성
	Scanner sc = new Scanner(System.in);
	
	// 기능 // 오버로딩 = 같은 이름 메서드의 여러형태, 매개변수 차이가 중요
	public int sum(int n1, int n2) {
		System.out.println("int sum(int n1, int n2) CALL");
		return n1 +n2;
	}
	public int sum() {
		System.out.println("int sum() CALL");
		return sc.nextInt() + sc.nextInt();
	}
	public int sum(int n1, int n2, int n3) {
		System.out.println("int sum(int n1, int n2, int n3) CALL");
		return n1 +n2 + n3;
	}
	public int sum(int n1, int n2, int n3, int n4) {
		System.out.println("int sum(int n1, int n2, int n3, int n4) CALL");
		return n1 +n2 + n3 + n4;
	}
}



public class C06MethodOverloading {

	public static void main(String[] args) {
		Cal2 cal = new Cal2();
		System.out.println("SUM1 : " + cal.sum(10, 20));
		System.out.println("SUM2 : "); System.out.println(cal.sum()); 
		System.out.println("SUM3 : " + cal.sum(10,20,30));
		System.out.println("SUM4 : " + cal.sum(10,20,30,40));

		

	}

}
