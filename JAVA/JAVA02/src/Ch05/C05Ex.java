package Ch05;

//이것이자바다 상속문제 
//https://velog.io/@kaihojun/%EC%9D%B4%EA%B2%83%EC%9D%B4-%EC%9E%90%EB%B0%94%EB%8B%A4-%EA%B0%9C%EC%A0%95%ED%8C%90-7%EC%9E%A5-%EC%83%81%EC%86%8D-%ED%99%95%EC%9D%B8-%EB%AC%B8%EC%A0%9C-%ED%92%80%EC%9D%B4

//명품자바 상속문제
//https://cs-ssupport.tistory.com/84

//[1번] 다음 main() 메소드와 실행 결과를 참고하여 TV를 상속받은 ColorTV 클래스를 작성하라.

class TV {

	String brand;
	int year;
	int inch;

	TV(String brand, int year, int inch) {
		this.brand = brand;
		this.year = year;
		this.inch = inch;
	}

	void show() {
		System.out.printf("%s에서 만든 %d년형 %d인칭 TV", brand, year, this.inch);
	}

}
class ColorTV extends TV{
	String Color;
	public ColorTV(String brand, int year, int inch, String Color) {
		super(brand, year, inch);
		this.Color = Color;
	}
	@Override
	public String toString() {
		return "ColorTV [Color=" + Color + ", brand=" + brand + ", year=" + year + ", inch=" + inch + "]";
	}

	public void printProperty() {
		System.out.println(this.brand + " " + this.year + "년형 " + this.inch + "인치 " + this.Color );
	}
	
	
	
	
}

public class C05Ex {

	public static void main(String[] args) {

		ColorTV myTV = new ColorTV("삼성",2026,32,"검정");
		myTV.printProperty(); // 삼성 2026년형 32인치 검정이 나오면 해결

	}
}

//
//--------------------------------------------
//문제 - 이것이자바다
//--------------------------------------------
//https://scksk.tistory.com/6
//
//클래스 기본문제
//1~7번 확인하기 
//
//12번-16번 확인하기
//
//--------------------------------------------
//--추가(명품자바)
//--------------------------------------------
//https://security-nanglam.tistory.com/213
//
//
//--------------------------------------------
//--추가
//--------------------------------------------
//https://iu-corner.tistory.com/entry/JAVA-%EC%9E%90%EB%B0%94-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%97%B0%EC%8A%B5-%EB%AC%B8%EC%A0%9C-%EB%AA%A8%EC%9D%8C-1
//

