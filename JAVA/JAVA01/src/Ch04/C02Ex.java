package Ch04;

import java.util.Scanner;

public class C02Ex {

	public static void main(String[] args) {
		//1.문제(삼항연산자 + 논리연산자)
		// 키보드로 국어/영어/수학 점수를 입력받아 각각의부분점수가 40점이상이고
		// 총점수합의 평균이 70점이상이면 '합격'
		// 미만이면 '불합격'을 출력합니다
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("국어/영어/수학 점수를 입력하세요 >>>> ");
		int kor = sc.nextInt();
		int eng = sc.nextInt();
		int math = sc.nextInt();
		double avg = (double)(kor + eng + math)/3;
		
//		String result = (kor>=40 && eng>=40 && math>=40 && avg >= 70) ? "합격" : "불합격";
		String grade = ((kor< 40) || (eng<40) || (math<40)) ? "불합격" : (avg >= 70) ? "합격" : "불합격";
		System.out.println("시험결과 : " + grade);
		
	

		//2.미니문제(%연산자) - N%2==0
		//키보드로 부터 정수값 2개를 입력받아
		//두수의 합이 짝수이면 "짝수입니다"
		//홀수이면 "홀수입니다" 를 출력하세요~
		
		System.out.printf("정수 2개를 입력해주세요 >>> ");
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		String sum = ((n1+n2)%2==0) ? "두수의 합은 짝수입니다" : "두수의 합은 홀수입니다";
		System.out.println(sum);
		
		sc.close();
		
	}

}
