package com.cogni.smart_shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cogni.smart_shop.bean.LoginBean;
import com.cogni.smart_shop.bean.ProductBean;
import com.cogni.smart_shop.service.LoginService;
import com.cogni.smart_shop.service.LoginServiceImpl;
import com.cogni.smart_shop.service.ProductService;
import com.cogni.smart_shop.service.ProductServiceImpl;

@WebServlet("/LoginServlet")
@MultipartConfig
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usertype = request.getParameter("userType");
		response.sendRedirect("Register.jsp?userType=" + usertype);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LoginService ls = new LoginServiceImpl();
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		String utype = request.getParameter("userType");
		System.out.println(uname+pass+utype);
		RequestDispatcher dispatcher = null;
		LoginBean lb = new LoginBean(uname, pass);
		if (ls.validateUser(lb, utype)) {
			if (utype.equalsIgnoreCase("M")) {
				dispatcher = request.getRequestDispatcher("EditProduct.jsp");
				dispatcher.forward(request, response);
			} else if (utype.equalsIgnoreCase("U")) {
				ProductService addProductService=new ProductServiceImpl();
				List<ProductBean> pb=addProductService.getAllProductBean();
				for(ProductBean pr:pb)
				{
						System.out.println(pr);
				}
				HttpSession session=request.getSession();
				session.setAttribute("products", pb);
				//response.sendRedirect("ProductList.jsp");
				
				 dispatcher = request.getRequestDispatcher("ProductList.jsp");
				  dispatcher.forward(request, response);
				 
			} else {
				dispatcher = request.getRequestDispatcher("Login.jsp");
				dispatcher.forward(request, response);
			}

		} else {
			dispatcher = request.getRequestDispatcher("Login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
