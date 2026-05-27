package Ch02;

import java.util.Scanner;

public class C03Ex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("나눗셈 위한 두 값을 입력하세요 : ");
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			System.out.println("나눗셈 결과 : " + n1 / n2); // N/0 시 예외발생
		} catch (ArithmeticException e) {
			e.printStackTrace();
			System.out.printf("두번째 수에 0을 제외한 수를 입력해주세요. : ");
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			System.out.println("나눗셈 결과 : " + n1 / n2);
		}
	}

}
