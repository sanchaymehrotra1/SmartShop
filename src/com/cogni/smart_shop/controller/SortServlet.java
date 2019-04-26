package com.cogni.smart_shop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cogni.smart_shop.bean.ProductBean;
import com.cogni.smart_shop.service.ProductService;
import com.cogni.smart_shop.service.ProductServiceImpl;

@WebServlet("/SortServlet")
public class SortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   public SortServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String basis=request.getParameter("basis");
		ProductService productService = new ProductServiceImpl();
		List<ProductBean> products = new ArrayList<ProductBean>();
		RequestDispatcher requestDispatcher = null;
		HttpSession session = request.getSession(true);
		products.addAll(productService.sortProducts(basis));
		session.setAttribute("products", products);
		requestDispatcher = request.getRequestDispatcher("ProductList.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
