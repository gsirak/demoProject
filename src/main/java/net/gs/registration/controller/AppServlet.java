package net.gs.registration.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.gs.registration.dataB.IssueDataB;
import net.gs.registration.model.Issue;

@WebServlet("/in")
public class AppServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IssueDataB issueDB = new IssueDataB();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = req.getParameter("button");
		if (action != null) {
			switch (action) {
			case "edit":
				goToEditIssue(req, resp);// update
				break;
			case "delete":
				deleteIssue(req, resp);
				break;
			case "new":
				goToNewIssue(req, resp);// insert
				break;
			case "list":
				listIssue(req, resp);
				break;
			case "save":
				newIssue(req, resp);
				break;
			case "update":
				editIssue(req, resp);
			case "back":
				listIssue(req, resp);
				break;
			}
		} else {
			listIssue(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

	// listIssue: list all issues from database.
	private void listIssue(HttpServletRequest req, HttpServletResponse resp) {

		try {
			List<Issue> listIssue = issueDB.selectAllIssues();
			req.setAttribute("listIssue", listIssue);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board.jsp");
			dispatcher.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// deleteIssue: deletes the selected issue from database geting the id from
	// board.jsp.
	private void deleteIssue(HttpServletRequest req, HttpServletResponse resp) {
		int id = Integer.parseInt(req.getParameter("id"));
		issueDB.deleteIssue(id);
		listIssue(req, resp);

	}

	// goToNewIssue: displays the newIssue.jsp.
	private void goToNewIssue(HttpServletRequest req, HttpServletResponse resp) {
		try {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/newIssue.jsp");
			dispatcher.forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// newIssue: saves the inserted issue from newIssue.jsp and returns to board.jsp
	// if the new issue is null remains in newIssue.jsp.
	private void newIssue(HttpServletRequest req, HttpServletResponse resp) {

		Issue issue = issueSetUp(req);

		if (issue.isNull()) {
			goToNewIssue(req, resp);

		} else {
			issueDB.insertIssue(issue);
			listIssue(req, resp);
		}

	}

	// issueSetUp: private method return an issue it's field given from a request.
	private Issue issueSetUp(HttpServletRequest req) {
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String type = req.getParameter("type");
		String employee = req.getParameter("employee");
		String dateOfBirth = req.getParameter("dateOfBirth");
		String lastModified = req.getParameter("lastModified");
		String lastEmpModified = req.getParameter("lastEmployeeModified");
		String creator = req.getParameter("userCreator");
		String status = req.getParameter("status");
		Issue issue = new Issue();
		issue.setTitle(title);
		issue.setDescription(description);
		issue.setType(type);
		issue.setEmployee(employee);
		issue.setDateOfBirth(dateOfBirth);
		issue.setLastModified(lastModified);
		issue.setLastEmployeeModified(lastEmpModified);
		issue.setUserCreator(creator);
		issue.setStatus(status);
		return issue;
	}

	// goToEditIssue: displays the editIssue.jsp, and passes an Issue object to
	// display it's fields.
	private void goToEditIssue(HttpServletRequest req, HttpServletResponse resp) {

		int id = Integer.parseInt(req.getParameter("id"));

		Issue issue = issueDB.selectIssue(id);
		req.setAttribute("issue", issue);
		try {

			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/editIssue.jsp");
			dispatcher.forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// editIssue: gets an issue from editIssue.jsp and calls the update method who
	// does the update in database with it's id.
	private void editIssue(HttpServletRequest req, HttpServletResponse resp) {
		Issue issue = issueSetUp(req);
		issue.setId(Integer.parseInt(req.getParameter("id")));

		if (issueDB.updateIssue(issue, issue.getId()) == 1) {
			listIssue(req, resp);
		} else {
			goToEditIssue(req, resp);
		}

	}
}
