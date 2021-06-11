package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.Case;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AuthorDao;
import com.daoimpl.AuthorDaoImpl;
import com.google.gson.Gson;
import com.models.Author;

/**
 * Servlet implementation class AuthorServlet
 */
@WebServlet("/AuthorServlet")
public class AuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AuthorDao authorDaoImpl = new AuthorDaoImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthorServlet() {
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

		System.out.println("Action : " + action);

		Integer result = null;
		Author author = null;
		Gson gson = new Gson();
		String jsonlist = "";
		String listData = "";

		switch (action) {
		case "create":
			String authorName = request.getParameter("name").toString();
			Integer publications = Integer.parseInt(request.getParameter("publications"));

			System.out.println("Name : " + authorName + ", publications : " + publications);

			author = new Author();
			author.setName(authorName);
			author.setNoOfPublications(publications);

			result = authorDaoImpl.addAuthor(author);

			Author a = authorDaoImpl.getAuthorByName(author.getName());

			response.setContentType("application/json");

			response.getWriter().print(gson.toJson(a));

			break;

		case "getAll":

			List<Author> allAuthors = authorDaoImpl.getAllAuthor();

			jsonlist = gson.toJson(allAuthors);

			response.setContentType("application/json");
			response.getWriter().print(jsonlist);
			break;

		case "update":
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			publications = Integer.parseInt(request.getParameter("publications"));

			System.out.println("ID : " + id);
			author = authorDaoImpl.getAuthorById(id);

			if (author != null) {
				author.setName(name);
				author.setNoOfPublications(publications);

				authorDaoImpl.updateAuthor(author);

			}

			listData = gson.toJson(author);

			response.setContentType("application/json");
			response.getWriter().print(listData);

			break;

		case "delete":
			id = Integer.parseInt(request.getParameter("id"));
				
			System.out.println("Id = "+id);
			author = authorDaoImpl.getAuthorById(id);

			if (author != null) {
				authorDaoImpl.deleteAuthor(author);

			}

			listData = gson.toJson(author);

			response.setContentType("application/json");
			response.getWriter().print(listData);

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
