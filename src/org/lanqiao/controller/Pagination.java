package org.lanqiao.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.PageInfo;

import com.google.gson.Gson;

/**
 * Servlet implementation class Pagination
 */
@WebServlet(name = "pagination", urlPatterns = { "/pagination.do" })
public class Pagination extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		if(cid==null){ //如果类别没输，加载默认类别
			cid="1";
		}
		String pageindex = request.getParameter("pageIndex");
		if(pageindex==null || pageindex.equals("0")){ //默认拿此类别的第1页数据;
			pageindex ="0";
		}
		int pagesize =5;
		
		org.lanqiao.service.GoodsService gs = new org.lanqiao.service.impl.GoodsServiceImpl();
		PageInfo pageinfo = gs.goodsList(cid, pagesize,Integer.parseInt(pageindex)+1);
		Gson gson = new Gson();
		response.getWriter().write(gson.toJson(pageinfo));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	

}
