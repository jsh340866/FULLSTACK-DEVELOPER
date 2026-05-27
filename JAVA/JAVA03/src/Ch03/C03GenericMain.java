package Ch03;


class Person {
	String name;
	int age;
	
	//모든 인자 생성자
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
}

class Man extends Person {

	public Man(String name, int age) {
		super(name, age);
	}

	@Override
	public String toString() {
		return this.name;
	}
	
}
class Woman extends Person {

	public Woman(String name, int age) {
		super(name, age);
		
	}

	@Override
	public String toString() {
		return this.name;
	}
	
}

class Couple <M extends Person, W extends Person> {
	private M role_man;
	private W role_woman;
	Couple(M role_man, W role_woman) {
		this.role_man = role_man;
		this.role_woman = role_woman;
	}
	@Override
	public String toString() {
		return "Couple [role_man=" + role_man + ", role_woman=" + role_woman + "] 은 커플입니다.";
	}
}

public class C03GenericMain {

	public static void main(String[] args) {
		Couple<Man,Woman> couple1 = new Couple<Man,Woman>(new Man("철수",20), new Woman("영희",20));
		System.out.println("커플 : " + couple1);
		
		Couple<Man,Man> couple2 = new Couple<Man,Man>(new Man("홍석천",55), new Man("풍자",40));
		System.out.println("커풀 : " + couple2);


	}

}
