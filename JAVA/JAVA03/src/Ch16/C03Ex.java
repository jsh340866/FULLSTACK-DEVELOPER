package Ch16;


// 덧셈, 뺄셈, 곱셈, 나눗셈을 수행하는 함수형 인터페이스를 정의
interface Calculator {
	int calculate(int num1, int num2);
}

public class C03Ex {

	public static void main(String[] args) {
		
		Calculator add = (n1,n2)->{return n1 + n2;};
		Calculator sub = (n1,n2)->{return (n1>n2)?n1-n2:n2-n1;};
		Calculator mul = (n1,n2)->{return n1 * n2;};
		Calculator div = (n1,n2)->{return n1 / n2;};
		
		//결과
		System.out.println(add.calculate(10,20));	//덧셈
		System.out.println(sub.calculate(30,10));	//뺄셈
		System.out.println(mul.calculate(10,20));	//곱셈
		System.out.println(div.calculate(100,5));	//나눗셈
		
		//출력결과
		//30
		//20
		//200
		//20
	}

}
