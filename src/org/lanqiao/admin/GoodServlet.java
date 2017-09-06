package org.lanqiao.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.PageInfo;

import com.google.gson.Gson;

@WebServlet(name = "goodservlet", urlPatterns = { "/good.do" })
public class GoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		org.lanqiao.service.GoodsService gs=new org.lanqiao.service.impl.GoodsServiceImpl();
		String cid=request.getParameter("cid");
		int pagesize=Integer.parseInt(request.getParameter("row"));
		System.out.println(pagesize);
		int pageindex=Integer.parseInt(request.getParameter("page"))-1;
		PageInfo pageinfo= gs.goodsList(cid, pagesize, pageindex);
		Map<String, Object> map = new HashMap<String,Object>();
	    map.put("total", pageinfo.getTotalnumber());
	    map.put("rows", pageinfo.getData());
	    Gson gson=new Gson();
	    response.getWriter().write(gson.toJson(map));
	}

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
