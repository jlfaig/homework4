/**
 *
 * Copyright: 2016 Jenny Faig & Tyler LaVecchia & William Breen
 */
package edu.elon.library;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import edu.elon.business.Book;
import edu.elon.data.BookDB;

public class LibraryServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request,
	  HttpServletResponse response)
	  throws ServletException, IOException {
    String url = "/Welcome.jsp";
    Book book = null;
    
    String action = request.getParameter("action");
    if (action == null) {
      action = "join";
    }
    
    if (action.equals("join")) {
      url = "/Welcome.jsp";
    }
    if (action.equals("display_checkout")) {
        url = "/Checkout.jsp";
    }
    if (action.equals("display_cart")) {
        url = "/Cart.jsp";
    }
    else if (action.equals("add")) {
      String firstName = request.getParameter("firstName");
      String lastName = request.getParameter("lastName");
      String email = request.getParameter("email");
      String title = request.getParameter("title");
      
      book = new Book(firstName, lastName, email, title);
      url = "/Return.jsp";
      BookDB.insert(book);
    }
    
    request.setAttribute("book", book);
    
    getServletContext().getRequestDispatcher(url)
	    .forward(request, response);
  }

  @Override
  protected void doGet(HttpServletRequest request,
	  HttpServletResponse response)
	  throws ServletException, IOException {
    doPost(request, response);
  }
}
