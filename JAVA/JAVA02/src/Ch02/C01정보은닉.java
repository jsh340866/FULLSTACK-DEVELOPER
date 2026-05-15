package Ch02;

// 접근 한정자

// 멤버/클래스의 접근범위 제한을 위한 예약어
// public				: 모든 클래스에서 접근가능
// private 			: 해당 클래스에서만 접근가능
// protected		: 상속 관계를 가지는 경우에는 접근가능
// default(기본) 	: 동일 패키지에 속한 클래스에서 접근가능

class C01Person {
	// 속성
	private String name;
	private int age;
	private String addr;

	// 생성자(모든인자 받는)
	public C01Person(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	// 기능
	
	// getter and setter 함수
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// toString() 재정의
	@Override
	public String toString() {
		return "C01Person [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
}

public class C01정보은닉 {

	public static void main(String[] args) {
			C01Person ob = new C01Person("홍길동",55,"대구");
//			ob.name = "남길동";
			ob.setName("남길동");
			System.out.println(ob); 
	}

}
