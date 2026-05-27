package Ch14;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

class Simple {

	String name;
	int age;
	String addr;

	// 모든인자 생성자
	public Simple(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	// 디폴트 생성자
	public Simple() {
		super();
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
		return "Simple [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}

}

public class C02Basic {

	public static Object genObject(Class<?> clazz) throws Exception {

		// 디폴트 생성자
		Constructor con = clazz.getDeclaredConstructor(null);
		Object obj = con.newInstance(null);
		return obj;
	}

	public static void main(String[] args) throws Exception {

		// 생성자 호출
		Simple ob1 = new Simple();
		System.out.println("ob1 : " + ob1);

		// 생성자 호출(with reflect)
		Class<?> clazz = Class.forName("Ch14.Simple");

		Constructor[] cons = clazz.getConstructors();
		for (Constructor con : cons) {
			System.out.println("con : " + con);
		}
		System.out.println("cons's length : " + cons.length);

		Constructor con = cons[0];
		Object ob2 = con.newInstance("홍길동", 30, "대구");
		System.out.println("ob2 : " + ob2);

		// 메서드 호출(with reflect)
		System.out.println("------------------------");

		Method setName = clazz.getDeclaredMethod("setName", String.class);
		Method getName = clazz.getDeclaredMethod("getName", null);

		setName.invoke(ob1, "남길동");
		System.out.println("setName ob1 : " + ob1);
		System.out.println("setName ob1 : " + getName.invoke(ob1, null));
		setName.invoke(ob2, "티모");
		System.out.println("setName ob2 : " + ob2);
		System.out.println("setName ob2 : " + getName.invoke(ob2, null));
		System.out.println("------------------------");

		// 필드 호출(with reflect)
		Field addr = clazz.getDeclaredField("addr");
		addr.set(ob1, "창원");
		addr.set(ob2, "울산");
		System.out.println("ob1 : " + ob1);
		System.out.println("ob2 : " + ob2);

		System.out.println("-----------------");
		System.out.println(genObject(Class.forName("Ch14.Simple")));
		System.out.println(genObject(Class.forName("Ch11.ServerMain")));
//		System.out.println(genObject( Class.forName("Ch05.C05GUI")));

	}

}
