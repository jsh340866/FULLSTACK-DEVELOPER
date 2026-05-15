package Ch07;

class Parent{
	int n1 = 100;
	final int n2 = 200;	// 심볼릭 상수
	
	void setN1(int n1) {
		this.n1 = n1;
	}
	void setN2(int n2) {
//		this.n2 = n2;	// 심볼릭 상수의 값 변경 불가
	}
	
	final void func1() {
		System.out.println("Parent's final void func1 !");
	}
}
final class Son extends Parent{
	//상위 클래스의 메서드에 final 지정시 하위클래스에서 재정의 불가능 
//	final void func1() {
//		System.out.println("Parent's final void func1 !");
//	}
}
//class endPoint extends Son		// final 로 지정된 class를 부모로 둘 수 없다 
//{
//	
//}
//final interface test{
//	
//}

public class C07FinalMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
