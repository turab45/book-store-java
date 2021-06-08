package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.daoimpl.UserDaoImpl;
import com.models.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao userDaoImpl = new UserDaoImpl();
	User user = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		switch (action) {
		case "register":
			String userName = request.getParameter("username");
			String password = request.getParameter("password");

			user = new User();
			user.setUserName(userName.toLowerCase());
			user.setPassword(password.toLowerCase());

			Integer result = userDaoImpl.addUser(user);

			if (result > 0) {
				response.sendRedirect("login.jsp");
			}

			break;

		case "login":
			userName = request.getParameter("username");
			password = request.getParameter("password");

			user = userDaoImpl.getUserByEmailAndPassword(userName.toLowerCase(), password.toLowerCase());

			if (user != null) {
				response.sendRedirect("home.jsp");
			}
			break;

		case "logout":
			response.sendRedirect("login.jsp");
			break;

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
