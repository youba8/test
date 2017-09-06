package org.lanqiao.admin;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.User;

import com.google.gson.Gson;

/**
 * Servlet implementation class Userservlet
 */
@WebServlet(name = "userservlet", urlPatterns = { "/userservlet.do" })
public class Userservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		org.lanqiao.service.UserService us=new org.lanqiao.service.impl.UserServiceImpl();
		String type=request.getParameter("type");
		System.out.println(type);
		List<User> list =us.userlist();
		Gson gson=new Gson();
		if(type!=null&&type.equals("list")){
			response.getWriter().write(gson.toJson(list));
		}
		if(type!=null&&type.equals("add"))
		{
			
			String uloginid = request.getParameter("uname");
			String uemail = request.getParameter("uemail");
			String upassword=request.getParameter("upassword");
			String usex = request.getParameter("usex");
			String utel = request.getParameter("utel");
			String uaddress = request.getParameter("uaddress");
			String userid = UUID.randomUUID().toString(); //生成主键值;
			String ustateid="B5868B7A06E54DAEB19658343D3A2B28";//有效;
			String uroleid="116F9526C319462780B9CA72F6BB9B41";//普通用户;
			User user =new User(userid, uemail, uloginid, upassword, usex, uaddress, utel, ustateid, uroleid);
			us.insertUser(user);
			response.getWriter().write("1");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
