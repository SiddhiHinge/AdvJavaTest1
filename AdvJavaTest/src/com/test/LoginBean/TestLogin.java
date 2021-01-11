package com.test.LoginBean;

public class TestLogin {

	String username;
	String password;
	
	public TestLogin() { }

	public TestLogin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

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

	@Override
	public String toString() {
		return "TestLogin [username=" + username + ", password=" + password + "]";
	}
}
