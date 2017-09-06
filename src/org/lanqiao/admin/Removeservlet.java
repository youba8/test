package org.lanqiao.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Order;

/**
 * Servlet implementation class Removeservlet
 */
@WebServlet(name = "removeservlet", urlPatterns = { "/removeservlet.do" })
public class Removeservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	org.lanqiao.service.OrderService os=new org.lanqiao.service.impl.OrderServiceImpl();
	org.lanqiao.service.OrderdetailService ods=new org.lanqiao.service.impl.OrderdetailServiceImpl();
	org.lanqiao.service.PasswordAnswerService pas=new org.lanqiao.service.impl.PasswordAnswerServiceImpl();
	org.lanqiao.service.UserService us=new org.lanqiao.service.impl.UserServiceImpl();
	String type=request.getParameter("type");
	String userid=request.getParameter("userid");
	String uroleid=request.getParameter("uroleid");
	System.out.println(uroleid);
	if(type!=null&&type.equals("del"))
	{
		
		Order order= os.getid(userid);
		if(order!=null&&uroleid!="377D0AE90A804D289F301FB085A6E9AA")
		{
		ods.remove(order.getOrderid());
		os.remove(userid);
		}
		if(!uroleid.equals("377D0AE90A804D289F301FB085A6E9AA"))
		{
	    System.out.println(uroleid);
		pas.remove(userid);
		us.remove(userid);
		response.getWriter().write("1");
		}
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
