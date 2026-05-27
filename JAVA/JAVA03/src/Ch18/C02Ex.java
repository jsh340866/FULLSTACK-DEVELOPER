package Ch18;

import java.util.Arrays;
import java.util.Comparator;

/* ----------------------------------------------------------
   2. [학생용 문제] 사칙연산 함수형 인터페이스 + Stream + Lambda
   ----------------------------------------------------------
   조건 :
     - sum / sub / mul / div 람다를 람다 + Stream 으로 구현
     - 모든 인자를 받을 수 있도록 가변인자 처리
     - 뺄셈 / 나눗셈은 큰 수 → 작은 수로 정렬 후 누적 감산 / 누적 제산
       (예: sub(1,4,2,9) → 정렬 9,4,2,1 → 9-4-2-1 = 2)

   정답 참고 : C02ExAns.java
   ---------------------------------------------------------- */

@FunctionalInterface
interface Functional {
	Integer execute(int ...args);
}

class Calc {
	Functional sum;   // 합
	Functional sub;   // 차
	Functional mul;   // 곱
	Functional div;   // 나누기

	Calc() {
		sum = arr->Arrays.stream(arr)
						 .reduce(0,(n,item)->n+item);
						 
						 
		sub = arr->Arrays.stream(arr)
						 .boxed()	// int를 Integer로 묶음.
						 .sorted((a,b)->(b-a))
						 .reduce((sub,item)->sub-item)
						 .orElse(0);	// reduce 초기값 없을시 기본'0'값
										// 오류 발생시 기본'0'값
		mul = arr->Arrays.stream(arr)
						 .reduce(1,(n,item)->n*item);
		div = arr->Arrays.stream(arr)
						 .boxed()
						 .sorted((a,b)->(b-a))
						 .reduce((div,item)->div/item)
						 .orElse(0);
		
	}

	
}

public class C02Ex {

	public static void main(String[] args) {
		Calc calc = new Calc();

		// 람다 채우면 아래 실행 가능
		// 기대 출력 :
		//   합     : 210
		//   차     : 2
		//   곱     : 720000000
		//   나눗셈 : 0
		// TODO 답안 작성 후 calc.sum / sub / mul / div 호출
		System.out.println("합\t : " + calc.sum.execute(10,20,30,40,50,60));
		System.out.println("차\t : " + calc.sub.execute(9,4,2,1));
		System.out.println("곱\t : " + calc.mul.execute(10,20,30,40,50,60));
		System.out.println("나눗셈\t : " + calc.div.execute(10,20,30,40,50,60));
		
		
		
	}
}
