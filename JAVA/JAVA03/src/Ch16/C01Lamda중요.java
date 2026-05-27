package Ch16;

import java.util.ArrayList;
import java.util.List;

class Person {
	private String name;
	private int age;
	private String addr;

	// 디폴트 생성자
	public Person() {
		super();
	}

	// 모든인자 생성자
	public Person(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	// getter and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	// toString 재정의
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}

}


public class C01Lamda중요 {

	public static void main(String[] args) {
		List<Person> list = new ArrayList();
		
		list.add(new Person("홍길동", 55,"대구"));
		list.add(new Person("남길동", 45,"창원"));
		list.add(new Person("서길동", 35,"울산"));
		
//		list.forEach((el)->{System.out.println(el);});
//		list.forEach(el->System.out.println(el));
//		list.forEach(System.out::println);
		
		list.sort((a,b)->{return a.getAge() - b.getAge();});
		list.forEach(System.out::println);
	}

}
