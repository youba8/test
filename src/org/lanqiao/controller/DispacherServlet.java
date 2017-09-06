package org.lanqiao.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Category;
import org.lanqiao.entity.Goods;
import org.lanqiao.entity.News;
import org.lanqiao.entity.User;
//主要业务实现转发的（因为用户不能直接访问WEB-INF下资源）
@WebServlet(name = "dispacher", urlPatterns = { "/dispacher.do" })
public class DispacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		String id = request.getParameter("id");
		if(type!=null && type.equals("news") && id!=null){
			//根据id取新闻的信息.....
			org.lanqiao.service.NewsService ns = new org.lanqiao.service.impl.NewsServiceImpl();
			News news = ns.getNewsById(id);
			request.setAttribute("news", news);
			request.getRequestDispatcher("/WEB-INF/title.jsp").forward(request, response);
		}else if(type!=null && type.equals("goods") && id!=null){
			//根据id找商品;
			org.lanqiao.service.GoodsService gs = new org.lanqiao.service.impl.GoodsServiceImpl();
			org.lanqiao.service.CategoryService cs = new org.lanqiao.service.impl.CategoryServiceImpl();
			Goods goods = gs.getGoodsBygid(id);
			//外键处理的一种方式;
			String cid = goods.getCid();
			Category cate = cs.getCategoryById(cid);
			request.setAttribute("goods", goods);
			request.setAttribute("cate", cate);
			
			request.getRequestDispatcher("/WEB-INF/detail.jsp").forward(request, response);
		}else if(type!=null && type.equals("reg") ){
			request.getRequestDispatcher("/WEB-INF/regedit.jsp").forward(request, response);
		}else if(type!=null && type.equals("loginsuccess") ){
			//判断有cookie;
			Cookie[] cookies = request.getCookies();
			Cookie userCookie = null;
			for(Cookie c:cookies){
				if(c.getName().equals("uloginid")){
					userCookie = c;
					break;
				}
			}
			if(userCookie!=null){
				String uloginid = userCookie.getValue();
				//根据帐号找此用户;
				org.lanqiao.service.UserService us =new org.lanqiao.service.impl.UserServiceImpl();
				User user =us.getUserByLoginId(uloginid);			
				request.getSession().setAttribute("user", user);
			}
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}else if(type!=null && type.equals("final") ){
			request.getRequestDispatcher("/WEB-INF/my.jsp").forward(request, response);
			
		}
		//
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
