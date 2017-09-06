package org.lanqiao.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Category;

import com.google.gson.Gson;

/**
 * Servlet implementation class CateServlet
 */
@WebServlet(name = "cateservlet", urlPatterns = { "/cate.do" })
public class CateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		org.lanqiao.service.CategoryService cs=new org.lanqiao.service.impl.CategoryServiceImpl();
		
		List<Category> list= cs.categoryList();
		System.out.println(list);
		Gson gson=new Gson();
		response.getWriter().write(gson.toJson(list));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
