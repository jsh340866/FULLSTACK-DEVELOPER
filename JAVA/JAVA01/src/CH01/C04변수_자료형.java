package CH01;

public class C04변수_자료형 {
//		RAM random access memory
	public static void main(String[] args) {
//		원시 자료형,변수
//		byte(1byte - signed)
//		char(2byte - unsigned)
//		short(2byte  signed)
//		int(4byte - signed) - 정수 기본자료형
//		float(4byte)
//		double(8byte) - 실수 기본자료형

		
//		클래스 자료형, 참조변수, 동적할당
//		String num = "abce"
		
		int num1;					// int만큼 크기(4byte)의 공간형성 + num1이름부여(변수 정의)
		num1 = 10;					// 10이라고 하는값(리터럴상수)을 상수POOL에 저장, num1공간에 대입(복사)
		int num2 = 4;				// 4라는 값(리터럴상수)을 상수POOL저장, 4byte정수공간 num2 초기화
		int num3 = num1 + num2;		// num1안의값과 num2안의값의 덤셋결과(CPU가산처리)를 4byte 정수공간 num3에 초기화
		System.out.println(num3);	// num3안의 값을 println메서드로 전달해서 내부적으로 표준출력 처리
		
		// Data(수,자료) : 선 저장 / 후 처리
		// 변수 : 개발자의 유지보수 측면에서 유리할도록 하기 위해 지정한 수(바뀔 예정인 수)
		// 변수명 : 저장되어져 있는 변수 공간에 접근하기 위한 문자 형태의 주소
		// 자료형 : Data(수,자료)를 저장하기 위한 공간을 형성하고 저장될 자료의 형태를 제한하는 예약어
		// =연산자 :
		// lv(공간) = rv(값) rv를 먼저 처리(저장 or 연산) 한 다음 lv에 대입
		
	}

}
