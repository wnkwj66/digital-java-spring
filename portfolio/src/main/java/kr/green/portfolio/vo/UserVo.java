package kr.green.portfolio.vo;

/**
 * @author Administrator
 *
 */
public class UserVo {
	private String id;
	private String pw;
	private String email;
	private String gender;
	private String auth;
	private String isDel;
	private int phone;
	private int age;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getIsDel() {
		return isDel;
	}
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "UserVo [id=" + id + ", pw=" + pw + ", email=" + email + ", gender=" + gender + ", auth=" + auth
				+ ", isDel=" + isDel + ", phone=" + phone + ", age=" + age + "]";
	}
	
	
}
