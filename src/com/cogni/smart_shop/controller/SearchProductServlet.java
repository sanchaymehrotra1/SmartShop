package com.cogni.smart_shop.controller;

import java.io.IOException;
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

@WebServlet("/SearchProductServlet")
public class SearchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchProductServlet() {
        super();

    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productName=(String) request.getParameter("Name");
		System.out.println(productName);
		ProductService productService = new ProductServiceImpl();
		List<ProductBean> productBeanList=productService.searchProducts(productName);
		System.out.println(productBeanList);
		RequestDispatcher requestDispatcher = null;
		HttpSession session = request.getSession(true);
		
		session.setAttribute("products", productBeanList);
		requestDispatcher = request.getRequestDispatcher("ProductList.jsp");
		requestDispatcher.forward(request, response);

	}

	}


