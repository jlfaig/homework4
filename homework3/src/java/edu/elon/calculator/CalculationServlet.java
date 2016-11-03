/**
 *
 * Copyright: 2016 Jenny Faig & Tyler LaVecchia
 */
package edu.elon.calculator;

import edu.elon.business.Calculation;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculationServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request,
	  HttpServletResponse response)
	  throws ServletException, IOException {

    String url = "/form.jsp";

    String action = request.getParameter("action");
    if (action == null) {
      action = "join";
    }

    if (action.equals("join")) {
      url = "/form.jsp";
    } else if (action.equals("add")) {
      String p = request.getParameter("principal");
      String r = request.getParameter("rate");
      String y = request.getParameter("years");

      Double principal = Double.parseDouble(p);
      Double rate = Double.parseDouble(r);
      Integer years = Integer.parseInt(y);

      Calculation calculation = new Calculation(principal, rate, years);

      String message;
      if (p == null || r == null || y == null || p.isEmpty()
	      || r.isEmpty() || y.isEmpty()) {
	message = "Please fill out all three text boxes.";
	url = "/form.jsp";
      } else {
	message = "";
	url = "/return.jsp";
      }
      request.setAttribute("calculation", calculation);
      request.setAttribute("message", message);
    }
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
