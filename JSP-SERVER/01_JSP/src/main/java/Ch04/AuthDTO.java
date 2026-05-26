package Ch04;



public class AuthDTO {

	private String userid;
	private String password;
	
	public AuthDTO() {
		super();
	}

	public AuthDTO(String userid, String password) {
		super();
		this.userid = userid;
		this.password = password;
	}

	@Override
	public String toString() {
		return "AuthDTO [userid=" + userid + ", password=" + password + "]";
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	
}
