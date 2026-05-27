package Ch05;

import java.util.Scanner;

class StudentEx2{
	private String name;
	private int id;

	void setName(String name) { // setter 네임
		this.name = name;
	}
	String getName() { // getter id
		return this.name+" 학과";
	}
	void setId(int id) {
		this.id = id;
	}
	int getId() {
		return this.id;
	}
}

public class C001Ex {

	public static void main(String[] args) {
		/*
		 * 다음을 만족하는 Student 클래스를 작성하시오
		 * String 형의 학과와 정수형의 학번을 필드로 선언 
		 * Student 클래스의 main()메소드에서 Student 객체를 생성하여 학과와 학번 필드에 
		 * 적당한 값을 입력한 후 출력
		 * 2. 위에서 구현한 Student 클래스를 다음을 만족하도록 기능을 추가하여 작성하시오.
          필드를 모두 private로 하고, getter와 setter를 구현하고 
          Student 클래스의 main() 메소드에서 Student 객체를 생성하여 setter를 사용하여 
			학과와 학번 필드에 적당한 값을 입력 후 출력
		 */
		Scanner sc = new Scanner(System.in);
		StudentEx2 student1 = new StudentEx2();
		
		System.out.println("---회원가입---");
		System.out.print("학과 입력 :");
		String name = sc.next();
		student1.setName(name);
		
		System.out.print("학번 입력 :");
		int id = sc.nextInt();
		student1.setId(id);
	      
		System.out.println("학생1의 학과 :"+student1.getName()+", 학번 :"+student1.getId());
		
		
		
	}

}