package Ch02;

public class C05UserDto {
	
	private String userid;
	private String password;
	private String rePassword;
	private String username;
	private String zipcode;
	private String addr1;
	private String addr2;
	private String ph01;
	private String ph02;
	private String ph03;
	private String tel01;
	private String tel02;
	private String tel03;
	private String email01;
	private String email02;
	private String birthType;
	private String birthYear;
	private String birthMonth;
	private String birthDay;
	private String email_recv;
	private String sms_recv;
	public C05UserDto() {
		super();
	}
	public C05UserDto(String userid, String password, String rePassword, String username, String zipcode, String addr1,
			String addr2, String ph01, String ph02, String ph03, String tel01, String tel02, String tel03,
			String email01, String email02, String birthType, String birthYear, String birthMonth, String birthDay,
			String email_recv, String sms_recv) {
		super();
		this.userid = userid;
		this.password = password;
		this.rePassword = rePassword;
		this.username = username;
		this.zipcode = zipcode;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.ph01 = ph01;
		this.ph02 = ph02;
		this.ph03 = ph03;
		this.tel01 = tel01;
		this.tel02 = tel02;
		this.tel03 = tel03;
		this.email01 = email01;
		this.email02 = email02;
		this.birthType = birthType;
		this.birthYear = birthYear;
		this.birthMonth = birthMonth;
		this.birthDay = birthDay;
		this.email_recv = email_recv;
		this.sms_recv = sms_recv;
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
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getPh01() {
		return ph01;
	}
	public void setPh01(String ph01) {
		this.ph01 = ph01;
	}
	public String getPh02() {
		return ph02;
	}
	public void setPh02(String ph02) {
		this.ph02 = ph02;
	}
	public String getPh03() {
		return ph03;
	}
	public void setPh03(String ph03) {
		this.ph03 = ph03;
	}
	public String getTel01() {
		return tel01;
	}
	public void setTel01(String tel01) {
		this.tel01 = tel01;
	}
	public String getTel02() {
		return tel02;
	}
	public void setTel02(String tel02) {
		this.tel02 = tel02;
	}
	public String getTel03() {
		return tel03;
	}
	public void setTel03(String tel03) {
		this.tel03 = tel03;
	}
	public String getEmail01() {
		return email01;
	}
	public void setEmail01(String email01) {
		this.email01 = email01;
	}
	public String getEmail02() {
		return email02;
	}
	public void setEmail02(String email02) {
		this.email02 = email02;
	}
	public String getBirthType() {
		return birthType;
	}
	public void setBirthType(String birthType) {
		this.birthType = birthType;
	}
	public String getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}
	public String getBirthMonth() {
		return birthMonth;
	}
	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getEmail_recv() {
		return email_recv;
	}
	public void setEmail_recv(String email_recv) {
		this.email_recv = email_recv;
	}
	public String getSms_recv() {
		return sms_recv;
	}
	public void setSms_recv(String sms_recv) {
		this.sms_recv = sms_recv;
	}
	@Override
	public String toString() {
		return "C05UserDto [userid=" + userid + ", password=" + password + ", rePassword=" + rePassword + ", username="
				+ username + ", zipcode=" + zipcode + ", addr1=" + addr1 + ", addr2=" + addr2 + ", ph01=" + ph01
				+ ", ph02=" + ph02 + ", ph03=" + ph03 + ", tel01=" + tel01 + ", tel02=" + tel02 + ", tel03=" + tel03
				+ ", email01=" + email01 + ", email02=" + email02 + ", birthType=" + birthType + ", birthYear="
				+ birthYear + ", birthMonth=" + birthMonth + ", birthDay=" + birthDay + ", email_recv=" + email_recv
				+ ", sms_recv=" + sms_recv + "]";
	}
	
	
	
	
}
