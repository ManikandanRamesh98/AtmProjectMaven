package com.bank.login;

public class Usernamepasspojo {
private int id;
private String username;
private String password;
private String created_at;
private String role;
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
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getCreated_at() {
	return created_at;
}
public void setCreated_at(String created_at) {
	this.created_at = created_at;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public Usernamepasspojo(int id, String username, String password, String created_at, String role) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
	this.created_at = created_at;
	this.role = role;
}

public Usernamepasspojo(String username, String password) {
	
	this.username = username;
	this.password = password;
}
public Usernamepasspojo(String username) {
	
	this.username = username;
}

public Usernamepasspojo(String username, String password, String role) {
	
	this.username = username;
	this.password = password;
	this.role = role;
}
@Override
public String toString() {
	return "Usernamepasspojo [id=" + id + ", username=" + username + ", password=" + password + ", created_at="
			+ created_at + ", role=" + role + "]";
}


}
