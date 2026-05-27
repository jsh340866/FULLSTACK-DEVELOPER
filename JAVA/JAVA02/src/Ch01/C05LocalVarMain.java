package Ch01;

// 변수 종류

// 멤버 변수				: 클래스 내부 - 메서드 영역 외부 사이, 객체 개별데이터 저장용도
// 지역 변수				: 특정 메서드 영역 내부에서 생성되는 변수
// (or 메서드 영역 내부에서 {}가 명시되어 있을때 해당{} 내에서 생성되는 변수도 포함)
// ex 파마이터 변수, 일반변수..


// static 변수		: 동일 클래스로부터 생성된 여러 객체간 공유하는 멤버변수

class Simple 
{
	//속성
	int num = 10;		//멤버변수
	
	//기능
	void Func1() {
		num++;				//멤버변수
		System.out.println("num : " + num);
		int num = 20;	//지역변수 num 정의
		num++;				//지역변수 ++
		this.num++;		//멤버변수 ++ 
		System.out.println("num : " + num);
	}
	void Func2() {
		System.out.println("num : " + num);
		if(num>0) {
			int num = 100;		//if 내의 지역변수 num
			System.out.println("num : " + num); // 지역변수 num
		}
		System.out.println("num : " + num);
		while(num<15) {
			int num = 100;
			System.out.println("num : " + num);
			num++;
		}
	}
	
	void Func3(int num) {
		this.num = num;
	}
	
}



public class C05LocalVarMain {

	public static void main(String[] args) {
		
	}

}
