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
import com.dao.BookDao;
import com.daoimpl.AuthorDaoImpl;
import com.daoimpl.BookDaoImpl;
import com.google.gson.Gson;
import com.models.Author;
import com.models.Book;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BookDao bookDaoImpl = new BookDaoImpl();
	AuthorDao authorDaoImpl = new AuthorDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		Gson gson = new Gson();
		
		switch (action) {
		case "getAll":
			List<Book> allBooks = bookDaoImpl.getAllBook();
			
			response.setContentType("application/json");
			response.getWriter().print(gson.toJson(allBooks));
			
			
			break;

		case "create":
			Book book = new Book();
			Author author = authorDaoImpl.getAuthorByName(request.getParameter("author"));
			
			book.setTitle(request.getParameter("name"));
			book.setAuthor(author);
			
			bookDaoImpl.addBook(book);
			
			Book b = bookDaoImpl.getBookByName(book.getTitle());
			
			response.setContentType("application/json");
			response.getWriter().print(gson.toJson(b));
			
			break;
		case "update":
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			book = bookDaoImpl.getBookById(id);
			book.setTitle(request.getParameter("name"));
			
			author = authorDaoImpl.getAuthorByName(request.getParameter("author"));
			
			book.setAuthor(author);
			
			bookDaoImpl.updateBook(book);
			
			response.setContentType("application/json");
			response.getWriter().print(gson.toJson(book));
			
		break;
		
		case "delete":
			id = Integer.parseInt(request.getParameter("id"));
			
			book = bookDaoImpl.getBookById(id);
			bookDaoImpl.deleteBook(book);
			
			response.setContentType("application/json");
			response.getWriter().print(gson.toJson(book));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
