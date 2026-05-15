package Ch04;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Person {
	String name;
	int age;

	// 디폴트 생성자
	public Person() {
		super();
	}

	// 모든인자 생성자
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	// toString 재정의
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	// hashcode 재정의
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(this.name,this.age);
	}

	// equals 재정의
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person down = (Person) obj;
			return this.name.equals(down.name) && this.age == down.age;
		}
		return false;
	}


}

public class C05SetMain {

	public static void main(String[] args) {

		Set<Person> set = new HashSet();
		Person ob1 = new Person("홍길동", 55);
		Person ob2 = new Person("남길동", 35);
		Person ob3 = new Person("홍길동", 55);

		System.out.println(ob1.equals(ob2));
		System.out.println(ob1.equals(ob3));

		set.add(ob1);
		set.add(ob2);
		set.add(ob3);

		System.out.println("SIZE : " + set.size());

	}

}
