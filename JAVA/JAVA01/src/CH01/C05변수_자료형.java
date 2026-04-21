package CH01;

import java.nio.charset.StandardCharsets;

public class C05변수_자료형 {

	public static void main(String[] args) {
//		//--------------------
//		//정수 int - 4byte 정수 부호 o
//		//--------------------
//		int n1 = 0b10101101;	//2진수 bit 
//		int n2 = 173;			//10진 정수값
//		int n3 = 0255;			//8진수 orcal
//		int n4 = 0xad;			//16진수 hex
//		System.out.printf("%d %d %d %d\n",n1,n2,n3,n4);

		
		// --------------------
		// 정수 byte - 1byte 정수 부호 o
		// --------------------
//		byte n5 = (byte)-129;			//? 1byte = 11111111 , 총 8bit로 구성되어있음. -128~127까지 가능함
//		byte n6 = -30;
//		byte n7 = 30;
//		byte n8 = 127;
//		byte n9 = (byte)129;			//?
//		System.out.println(n5);
//		System.out.println(n9);
//		System.out.println(Integer.toBinaryString(-30));

		
		// --------------------
		// 정수 byte - 1byte 정수 부호 o
		// --------------------
//		char n1 = 65535;	// (0 ~ 2^16-1) (0 ~ 65535)
//		short n2 = 32767;	// (-2^15 ~ +2^15-1)(-32768 ~ +32767)
		
//		char n3 = 30000;
//		short n4 = n3; 		// main stack 에 있는 문자형 n3를 가져와 자료형이 맞지않음 
//		short n5 = 30000; 	// 상수POOL에 저장한 30000을 가져오기 때문에 넣을수 있음
		
//		char n6 = 100;
//		int n7 = 100;
//		byte n8 = 100;
//		short n9 = n8;		// 더 작은 것은 담을 수 있음
//		short n10 = n7;		// 작은 것에 큰거를 담을 수는 없음
//		
//		System.out.printf("%d\n", n3); //  "%d\n", n3 오류 뜨는 이유 : char n1,n3는 숫자를 받아도 거기에 맞는 형태의 단어를 출력함 정수가 아님
//		System.out.println(Integer.toBinaryString(65535));
		
		
		
		// --------------------
		// 정수 long-8byte 정수 부호 o
		// --------------------
		
//		long n1 = 2150000000L;	// 21.5억
//		long n2 = 20;	// L,l (리터럴접미사) : long 자료형 사용하여 값 저장
//		
//		long n3 = 10000000000l;	// 기본적으로 정수는 int로 저장되 그 범위를 넘어서는 수는 접미사 L,l 을 붙여서 표기해줘야함
//		long n4 = 10000000000L;
		
		
		
		// --------------------
		// 실수
		// --------------------
		// 유리수와 무리수의 통칭
		// 소숫점이하값을 가지는 수 123.456
		// float : 4byte 실수(6-9자리)
		// double : 8byte 실수(15-18자리), 기본자료형
		
//		// 정밀도 확인
//		float n1 = 0.123456789123456789F; // f,F : float형 접미사
//		double n2 = 0.123456789123456789;
//		
//		System.out.println(n1);
//		System.out.println(n2);
//		
//		// 오차 확인 -- 실수를 반복사용하면 조금씩 오차가 생긴다. 반복값을 구할때 실수를 쓰면 실수가 생긴다
//		float num = 0.1F;
//		for(int i =0;i<=1E5;i++) {
//			num=num+0.1F;
//			System.out.println(i);
//		}
//		System.out.println("num : " + num);
		
		
		
		// --------------------
		// 단일문자 char 2byte 정수
		// --------------------
//		char ch1 = 'a';
//		System.out.println(ch1);
//		System.out.println((int)ch1);
//		System.out.println(Integer.toBinaryString(ch1));
//		System.out.println("-------------------");
//		
//		char ch2 = 98;
//		System.out.println(ch2);
//		System.out.println((int)ch2);
//		System.out.println(Integer.toBinaryString(ch2));
//		System.out.println("-------------------");
//		
//		char ch3 = 'b' + 1;
//		System.out.println(ch3);
//		System.out.println((int)ch3);
//		System.out.println(Integer.toBinaryString(ch3));
//		System.out.println("-------------------");
//		
//		System.out.println((char)0b1010110000000000); // '가'
//		char ch4 = 0xac02;
//		System.out.println(ch4);
//		System.out.println((int)ch4);
//		System.out.println(Integer.toBinaryString(ch4));
//		System.out.println("-------------------");
//		
//		System.out.println("-------------------");
//		// \\u : 유니코드 이스케이프문자
//		System.out.printf("%c\n", 0xac03);
//		System.out.printf("%c\n", '\uac03');
		
//		// --------------------
//		// boolean : 논리형(true/false 저장)
//		// --------------------
//		boolean flag = (10>11);	
//		if(flag)
//		{
//			System.out.println("참인경우 실행");
//		}
//		else {
//			System.out.println("거짓인경우 실행");
//		}

		
		// --------------------
		// 문자열 : String (클래스자료형)
		// --------------------
		//기본자료형(원시타입) '기본변수'
		//byte n1;
		//short n2;
		//double n3;
		//long n4;
		
		//클래스자료형
		//클래스자료형으로 만든변수는 '참조변수'라고 하고
		//참조변수는 데이터가 저장된 위치정보(메모리주소값)이 저장된다.
		int n1 = 10;	// 상수POOL에 저장된 값를 가져옴
		byte n2 = 20;
		char n3 = 40;
		
		String name = "홍길동"; // 상수POOL에 저장된 객체(홍길동)의 주소값을 가져옴
		String job = "프로그래머";
		
		System.out.println("UTF-8기준 지정 크기: " + name.getBytes(StandardCharsets.UTF_8).length);
		System.out.println("UTF-8기준 지정 크기: " + job.getBytes(StandardCharsets.UTF_8).length);

		
		// 사이즈 확인
		char ch = '홍';		//16bit == 2byte 사용
		String str= "홍";	//24bit == 3byte 사용
		
		System.out.println("ch 실제 크기(bit): " + Integer.toBinaryString(ch).length());
		System.out.println("str 실제 크기(byte): " + str.getBytes(StandardCharsets.UTF_8).length);		
		
		

	}
}
