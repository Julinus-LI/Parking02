package pers.arrayli.domain; 

/**
 * @author lzj13
 * 用户基本信息 bean
 */
public class UserInfo {
	private int id;				// 用户Id
	private String username;	// 用户姓名
	private String pwd;			// 用户密码
	private int age;			// 用户年龄
	private String tel;			// 用户电话
	private int money;			// 用户的余额
	private String type;		// 用户类型是vip用户还是普通用户
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", username=" + username + ", pwd=" + pwd + ", age=" + age + ", tel=" + tel
				+ ", money=" + money + ", type=" + type + "]";
	}
}
 