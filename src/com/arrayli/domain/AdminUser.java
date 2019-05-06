package com.arrayli.domain; 

/**
 * @author lzj13
 * 管理员用户bean
 */
public class AdminUser {
	private int id;   		  		// 管理员用户id
	private String userName;  		// 管理员用户姓名
	private String userPassword;  	// 管理员用户密码
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "AdminUser [id=" + id + ", userName=" + userName + ", userPassword=" + userPassword + "]";
	}
	
}
 