package net.gs.registration.model;

public class Employee {

	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//isNull: returns true if some specific fields of the object are empty or "not valid" 
	public boolean isNull() {
		if (getFirstName() == "" || getLastName() == "" || getUserName() == "" || getPassword() == "") {
			return true;
		}

		return false;
	}

}
