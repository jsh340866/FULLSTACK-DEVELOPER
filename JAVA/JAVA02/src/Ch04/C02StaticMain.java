package Ch04;

class C02Simple{
	static int n1;
	int n2;
	
	void func1() {
		n1 = 100;
		n2 = 200;
	}
	
	static void func2() {
		n1 = 300;
//		n2 = 400; // static 함수에서 사용되는 변수는 static변수 or 지역변수만 사용가능하다. 
				  // static은 미리 만들어둬야하는데 일반멤버는 만들어질지 아닐지 알수없음
	}
	
}

public class C02StaticMain {

	public static void main(String[] args) {
		

	}

}
