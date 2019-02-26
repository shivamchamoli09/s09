package com.cognizant.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.dao.CustomerDAO;
import com.cognizant.helper.FactoryCustomerDAO;
import com.cognizant.helper.Status;

/**
 * Servlet implementation class LoginControllerClass
 */
@WebServlet(name = "LoginController", urlPatterns = { "/login" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int attempt=0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName= request.getParameter("userName");
		String password= request.getParameter("password");
		CustomerDAO customerDAO=FactoryCustomerDAO.createCustomerDAO();
		RequestDispatcher rd= request.getRequestDispatcher("addproduct.jsp");
		Status result = customerDAO.authCustomer(userName, password,attempt);
		if(result.equals(Status.ACCEPT)){
			rd.forward(request, response);
		}
		else if(result.equals(Status.DENY)){
			attempt=attempt+1;
			response.sendRedirect("index.html");
		}
		else {
			response.sendRedirect("locked.html");
		}
	}

}
