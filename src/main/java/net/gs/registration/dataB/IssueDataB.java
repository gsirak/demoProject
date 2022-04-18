package net.gs.registration.dataB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import net.gs.registration.model.Issue;

public class IssueDataB {

	// selectIssue: runs a select query to the database (issue table) to get all the
	// featured from a given id.
	public Issue selectIssue(int id) {
		String SELECT_ISSUE_SQL = "select * from issue where id = (?)";
		Issue issue = new Issue();

		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(SELECT_ISSUE_SQL)) {
			ps.setInt(1, id);
			ResultSet selected_items = ps.executeQuery();

			if (selected_items.first()) {
				issue.setId(selected_items.getInt("id"));
				issue.setTitle(selected_items.getString("title"));
				issue.setDescription(selected_items.getString("_description"));
				issue.setType(selected_items.getString("_type"));
				issue.setEmployee(selected_items.getString("employee"));
				issue.setDateOfBirth(selected_items.getString("date_of_birth"));
				issue.setLastModified(selected_items.getString("last_modified"));
				issue.setLastEmployeeModified(selected_items.getString("last_employee_modified"));
				issue.setUserCreator(selected_items.getString("creator"));
				issue.setStatus(selected_items.getString("_status"));
			}
			return issue;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return issue;

	}

	// selectAllIssues: runs a select query to database to get all the data, and
	// returns a list of Issues.
	public List<Issue> selectAllIssues() {
		String SELECT_ISSUES_SQL = "select * from issue;";

		List<Issue> list = new ArrayList<>();
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(SELECT_ISSUES_SQL)) {

			ResultSet selected_items = ps.executeQuery();

			while (selected_items.next()) {
				Issue issue = new Issue();
				issue.setId(selected_items.getInt("id"));
				issue.setTitle(selected_items.getString("title"));
				issue.setDescription(selected_items.getString("_description"));
				issue.setType(selected_items.getString("_type"));
				issue.setEmployee(selected_items.getString("employee"));
				issue.setDateOfBirth(selected_items.getString("date_of_birth"));
				issue.setLastModified(selected_items.getString("last_modified"));
				issue.setLastEmployeeModified(selected_items.getString("last_employee_modified"));
				issue.setUserCreator(selected_items.getString("creator"));
				issue.setStatus(selected_items.getString("_status"));

				list.add(issue);

			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	// deleteIssue: runs delete query in database to delete an issue with the given
	// id.
	public boolean deleteIssue(int id) {
		String DELETE_ISSUE_SQL = "delete from issue where id = (?)";
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(DELETE_ISSUE_SQL)) {

			ps.setInt(1, id);
			return ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	// insertIssue: runs an insert query in database to insert the given Issue
	// object.
	public void insertIssue(Issue issue) {
		String INSERT_ISSUE_SQL = "insert into issue "
				+ " (title, _description, _type, employee, date_of_birth, last_modified, last_employee_modified, creator, _status) values "
				+ " (?,?,?,?,?,?,?,?,?);";
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(INSERT_ISSUE_SQL)) {
			ps.setString(1, issue.getTitle());
			ps.setString(2, issue.getDescription());
			ps.setString(3, issue.getType());
			ps.setString(4, issue.getEmployee());
			ps.setString(5, issue.getDateOfBirth());
			ps.setString(6, issue.getLastModified());
			ps.setString(7, issue.getLastEmployeeModified());
			ps.setString(8, issue.getUserCreator());
			ps.setString(9, issue.getStatus());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// updateIssue: runs an update query in database updating all the field of the
	// row with the given id with the values of the given Issue object.
	public int updateIssue(Issue issue, int id) {
		String UPDATE_ISSUE_SQL = "update issue set title=(?), _description =(?), _type=(?), employee=(?), date_of_birth=(?), last_modified=(?), last_employee_modified=(?), creator=(?), _status=(?)"
				+ "where id = (?)";

		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(UPDATE_ISSUE_SQL)) {

			ps.setString(1, issue.getTitle());
			ps.setString(2, issue.getDescription());
			ps.setString(3, issue.getType());
			ps.setString(4, issue.getEmployee());
			ps.setString(5, issue.getDateOfBirth());
			ps.setString(6, issue.getLastModified());
			ps.setString(7, issue.getLastEmployeeModified());
			ps.setString(8, issue.getUserCreator());
			ps.setString(9, issue.getStatus());
			ps.setInt(10, id);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// getConnection: private method provides the connection to the database to the
	// other methods of the class.
	private Connection getConnection() throws SQLException {
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
