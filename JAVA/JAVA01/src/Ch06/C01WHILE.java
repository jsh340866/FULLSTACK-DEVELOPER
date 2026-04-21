package Ch06;

import java.util.Scanner;

public class C01WHILE {

	public static void main(String[] args) {
		// 00 기본 문법

//	while(조건식) {
//		조건식이 true 인 동안 실행되는 종속문장
//	}

		// 01 HELLOWORLD 10회 출력
		// 탈출용 변수 : i=0
		// 탈출 조건식 : i<10
		// 탈출 연삭식 : i++

//		int i = 0;
//		while(i<10) {
//			System.out.println("HELLOWORLD");
//			i++;
//		}

		// 02 HELLOWORLD N회 출력(N>0)
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		
//		if(n<0) {
//			System.out.println("N은 0보다 커야 합니다.");
//			System.exit(-1);
//		}
//		
//	
//		int i = 0;
//		while(i<n) {
//			System.out.println("HELLOWORLD");
//			i++;
//		}
//		
//		sc.close();

		// 03 1 부터 10까지 합 구하기

//		int i = 1;
//		int sum = 0;
//		while(i<=10) {
//			sum += i;
//			i++;
//		}
//		System.out.println("1부터 10까지의 합 : " + sum);
//		

		// 1.1부터 N까지의 합
		// 2.N부터 M까지의 합(N<M)
		// 3.N부터 M까지의 범위에서 짝수의 합과 홀수의 합 구해서 출력(N<M)
		// 4.구구단 2 x 1 = 1, 2 x 9 = 18 찍기
		// 5.구구단 N단 받아서 찍어보기

		// 문제1.
//		Scanner sc = new Scanner(System.in);
//		System.out.printf("정수를 입력하세요 >>>");
//		
//		int i = 1;
//		int N = sc.nextInt();
//		int sum = 0;
//		while(i<=N) {
//			sum += i;
//			i++;
//		}
//		System.out.println("1부터 " + N + "까지의 합 : " + sum);
//		sc.close();

		// 문제2.
//		Scanner sc = new Scanner(System.in);
//		System.out.printf("두 정수를 입력하세요 >>>");
//		int N = sc.nextInt();
//		int M = sc.nextInt();
//		int i = N;
//		int sum = 0;
//		while (i <= M) {
//			sum += i;
//			i++;
//		}
//		System.out.println(N + "부터 " + M + "까지의 합 : " + sum);
//		sc.close();

		// 문제3.
//		Scanner sc = new Scanner(System.in);
//		System.out.printf("두 정수를 입력하세요 >>>");
//		int N = sc.nextInt();
//		int M = sc.nextInt();
//		int i = N;
//		int sum1 = 0;
//		int sum2 = 0;
//		while (i <= M) {
//			if(i%2==0) {
//				sum1 += i;
//			}
//			else {
//				sum2 += i;
//			}
//			i++;
//		}
//		System.out.println(N + "부터 " + M + "까지의 짝수 합 : " + sum1);
//		System.out.println(N + "부터 " + M + "까지의 홀수 합 : " + sum2);
//		sc.close();

		// 문제4.
//		System.out.println("2단");
//		int i = 1;
//		while (i<10) {
//			System.out.printf("2 x %d\n",i);
//			i++;
//		}
		
		// 문제5.
//		Scanner sc = new Scanner(System.in);
//		System.out.printf("단을 입력해주세요. >>> ");
//		int dan = sc.nextInt();
//		int i = 1;
//		while(i<10) {
//			System.out.printf("%d x %d\n",dan,i);
//			i++;
//		}
		
	}

}
