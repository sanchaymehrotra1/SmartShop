package com.cogni.smart_shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cogni.smart_shop.bean.ProductBean;
import com.cogni.smart_shop.service.ProductService;
import com.cogni.smart_shop.service.ProductServiceImpl;

@WebServlet("/DeleteProductServlet")
@MultipartConfig
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService ps = new ProductServiceImpl();

	public DeleteProductServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<ProductBean> productBeanList = ps.getAllProductBean();
		HttpSession session = request.getSession();
		session.setAttribute("productBeanList", productBeanList);
		response.sendRedirect("DeleteProduct.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String del=request.getParameter("Product_Name");
		ProductBean pb=new ProductBean();
		//pb.setProduct_name(del);
		if(ps.deleteProduct(pb, del))
		{
			HttpSession session=request.getSession();
 			
 			List<ProductBean> productBeanList=ps.getAllProductBean();
 			session.setAttribute("productBeanList", productBeanList);
 			request.getRequestDispatcher("EditProduct.jsp").forward(request, response);
		}
		else   
		{
           
             request.getRequestDispatcher("DeleteProduct.jsp").include(request, response);
		}
	}

}


