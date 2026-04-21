package CH03;

import java.util.Scanner;

public class C02Scanner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 입력 :");
		int num1 = sc.nextInt();
		System.out.println("입력된 정수 값 : "+num1);
		
		System.out.println("실수 입력 : ");
		double num2 = sc.nextDouble();
		System.out.println("입력된 실수 값 : "+num2);
		
		System.out.println("문자열 입력 :");
//		String str1 = sc.next();		//문자열 입력 받기 함수, 띄어쓰기는 포함X
//		System.out.println("입력된 문자열 : "+ str1);
		
		sc.nextLine();		// nextLine()을 한번더 써서 \n을 건너띄어 줘야한다
		String str2 = sc.nextLine();		//문자열 입력 받기 함수, 띄어쓰기는 포함X
		System.out.println("입력된 문자열 : "+ str2);
		
		sc.close();

	}

}
