package Ch17;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


class Person {
	protected String name;
	protected Integer age;
	//디폴트
	public Person() {};
	
	//모든인자
	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	//getter and setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	//toString
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}

class Employee extends Person {
	private String department;
	private String role;
	
//	Employee(){}
	
	public Employee(Person person) {
		this.name = person.getName();
		this.age = person.age;
		this.department = "인턴";
		this.role = "-";
	}

	public Employee(String name, Integer age, String department, String role) {
		super(name, age);
		this.department = department;
		this.role = role;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [department=" + department + ", role=" + role + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
	
	
	
	
}

public class C01StreamMain {

	public static void main(String[] args) {
		
		// init
		List<Integer> li1 = Arrays.asList(1,2,3,4,5);
		System.out.println("li1 : " + li1);
		
		// filter 함수
		List<Integer> li2 = li1.stream()
							   .filter((n)->{return n%2==0;})	// filter 의 return = 조건식
							   .collect(Collectors.toList());	// 받은 값을 다시 리스트로 만듬
		System.out.println("li2 : " + li2);
		
		// map 함수
		List<Integer> li3 = li1.stream()
							   .filter((n)->{return n%2==1;})	// 1,3,5
							   .map((n)->{return n*n;})			// 받은 값 수정 1,9,25
							   .collect(Collectors.toList());
		System.out.println("li3 : " + li3);
		
		// sorted 함수
		List<Person> persons = Arrays.asList(
									new Person("홍길동",45),
									new Person("남길동",55),
									new Person("서길동",35),
									new Person("유재석",53),
									new Person("서장훈",32),
									new Person("강호동",27)
								);
				
		// 나이순으로 내림차순 정렬
		persons.stream()
			   .sorted((a,b)->{return b.getAge()-a.getAge();})	// sorted 의 return = 정렬 순서, a-b 오름차순, b-a 내림차순
			   .forEach((e)->{System.out.println(e);});
		
//		List<Integer> ages = persons.stream()
//									.map((el)->{return el.getAge();})
//									.collect(Collectors.toList());
//		System.out.println(ages);
			   
		List<Integer> ages = persons.stream()
									.map(Person::getAge)
									.collect(Collectors.toList());
		System.out.println(ages);
		
		// 이름 추출 후 길이로 변환
		List<Integer> nameLengths = persons.stream()
										   .map((el)->{return el.getName().length();})
										   //.map(Person::getName)
										   //.map(String::length)
										   .sorted((a,b)->{return a-b;})
										   .collect(Collectors.toList());
		System.out.println("이름 길이 : " + nameLengths);
//		Employee ob = new Employee(el.getName(),el.getAge(),null,null);
//		  return ob;
		// persons 의 Person 객체를 Employee 로 변환해서 저장
		// Employee 의 상위 클래스는 Person
		// 부서속성(String department) , 직책속성(String role) 추가
		// 디폴트생성자,모든인자,getter and setter, toString 재정의 할 것
		List<Employee> employees = persons.stream()
										  .map((person)->{return new Employee(person);})
										  .collect(Collectors.toList()); 	
		//TODO(코드구현 위치)
		System.out.println("Employee 변환 : ");
		employees.forEach(System.out::println);
		
		
		
		
	}

}
