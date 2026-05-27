package Ch02;

import java.util.*;

class Profile
{
	// 속성
	private String name;
	private String addr;
	private String job;
	private String major;
	// 생성자
	// 1)디폴트생성자 삽입
	public Profile() {
		super();
	}
	// 2)모든 인자 받는 생성자 삽입
	// 3)"홍길동,대구,프로그래머,컴퓨터공학" 을 받아 ,를 기준으로 잘라서 각 멤버에 저장
	public Profile(String string) {
		super();
		String[] str = string.split(",");
		this.name = str[0];
		this.addr = str[1];
		this.job = str[2];
		this.major = str[3];
	}
	

	// 기능
	// 1) 멤버변수를 은닉화 하고 getter and setter 를 만들어줍니다
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	// 2) toString 코드를 삽입
	@Override
	public String toString() {
		return "Profile [name=" + name + ", addr=" + addr + ", job=" + job + ", major=" + major + "]";
	}
	
	// 3) boolean isContain(String findstr) 함수 완성하기
	// findstr의 문자열이 각멤버인 name,addr,job,major 중 하나라도 포함되어 있으면 true 리턴
	// 아니면 false 리턴
	public boolean isContain(String findstr) {
		if(this.name.contains(findstr) || this.addr.contains(findstr) || this.job.contains(findstr) || this.major.contains(findstr)) {
			return true;
		}
		else return false;
	}
	
	// 4) boolean isEquals(String str) {} 완성하기
	//all로 받은 문자열을 , 단위로 잘라내어(split(",")) 각각 나눠진 문자열이
	//"name,addr,job,major" 와 일치 하면 true
	//아니면 false 를 리턴
	public boolean isEquals(String string) {
		String[] str = string.split(","); // 0 name, 1 addr, 2 job, 3 major
		if(this.name.equals(str[0]) && this.addr.equals(str[1]) && this.job.equals(str[2]) && this.major.equals(str[3])) {
			return true;
		}
		else return false;
		
	}
	
	
}

public class C06Ex {

	public static void main(String[] args) {
		Profile hong = new Profile("홍길동,대구,프로그래머,컴퓨터공학");
		System.out.println(hong.toString());
		System.out.println("길동 포함여부 : " + hong.isContain("길동")); // true
		System.out.println("컴퓨터 포함여부 : " + hong.isContain("컴퓨터")); // true
		System.out.println("프로필 일치여부 : " + hong.isEquals("홍길동,대구,프로그래머,컴퓨터공학"));// true
		System.out.println("프로필 일치여부 : " + hong.isEquals("홍길동,울산,프로그래머,컴퓨터공학"));// false
	}
}
