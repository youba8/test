package org.lanqiao.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.User;



/**
 * Servlet implementation class Login
 */
//@WebServlet(name = "login", urlPatterns = { "/login.do" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ulogin=request.getParameter("ulogin");
		String upassword=request.getParameter("upassword");
		org.lanqiao.service.UserService us=new org.lanqiao.service.impl.UserServiceImpl();
		User user=us.login(ulogin, upassword);
		if(user!=null)
		{
			response.getWriter().write("1");
		}else{
			response.getWriter().write("0");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
