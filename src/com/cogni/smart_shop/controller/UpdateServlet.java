package com.cogni.smart_shop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.cogni.smart_shop.bean.ProductBean;
import com.cogni.smart_shop.service.ProductService;
import com.cogni.smart_shop.service.ProductServiceImpl;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//ProductBean pb = new ProductBean();
		ProductService ps = new ProductServiceImpl();
		String name = request.getParameter("Product_Name");
		int item = Integer.parseInt(request.getParameter("Item"));
		if (ps.updateProduct(name, item)) {

			request.getRequestDispatcher("EditProduct.jsp").forward(request, response);
		} else {

			request.getRequestDispatcher("UpdateProduct.jsp").include(request, response);
		}
	}

}
