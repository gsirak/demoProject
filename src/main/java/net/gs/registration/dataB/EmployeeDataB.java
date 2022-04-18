package net.gs.registration.dataB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.gs.registration.model.Employee;

public class EmployeeDataB {

	public int registerEmployee(Employee emp) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "insert into employee"
				+ " (first_name, last_name, user_name, password, email) values " + " (?,?,?,?,?);";

		int result = 0;

		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(INSERT_USERS_SQL)) {

			ps.setString(1, emp.getFirstName());
			ps.setString(2, emp.getLastName());
			ps.setString(3, emp.getUserName());
			ps.setString(4, emp.getPassword());
			ps.setString(5, emp.getEmail());

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	// checkEmployee: runs a select query to database to get the password for a
	// given user name.
	public int checkEmloyee(String userName, String password) throws ClassNotFoundException {
		String SELECT_USERS_SQL = "select password from employee " + "where user_name = (?);";
		int result = 0;

		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(SELECT_USERS_SQL)) {

			ps.setString(1, userName);
			ResultSet selected_items = ps.executeQuery();

			selected_items.first();
			if (selected_items.getString("password").equals(password)) {
				result = 1;
			}
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	// getConnection: private method provides the connection to the database to the
	// other methods of the class.
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?useSSL=false", "root",
					"fornezi40");// here you should enter your port, user name and password to connect with the
									// database, the queries are at the sql folder at the uploaded files.
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return conn;

	}

}
