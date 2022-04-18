package net.gs.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.gs.registration.dataB.EmployeeDataB;
import net.gs.registration.model.Employee;

@WebServlet("/form")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmployeeDataB empDB = new EmployeeDataB();

	public EmployeeServlet() {
		super();
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("button");
		if (action != null) {
			switch (action) {
			case "login":
				goToLogIn(req, resp);
				break;
			case "submit":
				doSubmit(req, resp);
				break;
			case "ok":
				checkEmployee(req, resp);
				break;
			case "back":
				displayForm(req, resp);
				break;
			default:
				break;
			}
		} else {
			displayForm(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		this.doGet(req, resp);
	}

	//displayForm: displays the registerForm.jsp.
	private void displayForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/registerForm.jsp");
		dispatcher.forward(req, resp);
	}

	//goToLogIn: displays the userLogin.jsp
	private void goToLogIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/userLogin.jsp");
		dispatcher.forward(req, resp);
	}

	//doSubmit: creates an employee object with the given fields and calls the method who inserts the employee in database.
	private void doSubmit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		String email = req.getParameter("email");

		Employee emp = new Employee();
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setUserName(userName);
		emp.setPassword(password);
		emp.setEmail(email);

		try {
			if (emp.isNull()) {
				displayForm(req, resp);
			} else {
				empDB.registerEmployee(emp);
				resp.sendRedirect(req.getContextPath() + "/in");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	//checkEmployee: get user name and password from userLogin.jsp and if exist in database sends redirect to /in.
	private void checkEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");

		try {
			if (1 == empDB.checkEmloyee(userName, password)) {
				resp.sendRedirect(req.getContextPath() + "/in");
			} else {
				displayForm(req, resp);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
