package Ch02;

public class C04TestDto {
	
	private String username;
	private String password;
	private String bgcolor;
	
	//디폴트 생성자
	public C04TestDto() {
		super();
	}
	
	//모든인자 생성자
	public C04TestDto(String username, String password, String bgcolor) {
		super();
		this.username = username;
		this.password = password;
		this.bgcolor = bgcolor;
	}
	
	//getter and setter(★)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBgcolor() {
		return bgcolor;
	}
	public void setBgcolor(String bgcolor) {
		this.bgcolor = bgcolor;
	}
	
	//toString 재정의
	@Override
	public String toString() {
		return "C04TestDto [username=" + username + ", password=" + password + ", bgcolor=" + bgcolor + "]";
	}
	
	
	
}
