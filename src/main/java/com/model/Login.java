package com.model;

/**
 * Model class for user login
 * 
 * @author group 14
 *
 */
public class Login {
	private String email;
	private String password;



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = MD5.getMd5(password);
	}
}