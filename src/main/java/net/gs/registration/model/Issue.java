package net.gs.registration.model;

public class Issue {
	private int id;
	private String title;
	private String description;
	private String type;
	private String employee;
	private String dateOfBirth;
	private String lastModified;
	private String lastEmployeeModified;
	private String userCreator;
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getLastModified() {
		return lastModified;
	}

	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	public String getLastEmployeeModified() {
		return lastEmployeeModified;
	}

	public void setLastEmployeeModified(String lastEmployeeModified) {
		this.lastEmployeeModified = lastEmployeeModified;
	}

	public String getUserCreator() {
		return userCreator;
	}

	public void setUserCreator(String userCreator) {
		this.userCreator = userCreator;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	//isNull: returns true if some specific fields of the object are empty or "not valid" 
	public boolean isNull() {
		if (title == "" || type == "" || dateOfBirth == "" || userCreator == "") {
			return true;
		} else {
			return false;
		}
	}

}
