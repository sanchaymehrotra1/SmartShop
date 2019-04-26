package com.cogni.smart_shop.controller;

import java.io.IOException; 
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.servlet.http.Part;
import javax.servlet.http.Part;

import com.cogni.smart_shop.bean.ProductBean;
import com.cogni.smart_shop.service.ProductService;
import com.cogni.smart_shop.service.ProductServiceImpl;

@WebServlet("/ProductController")
@MultipartConfig

public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProductController() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService addProductService=new ProductServiceImpl();
		List<ProductBean> pb=addProductService.getAllProductBean();
		HttpSession session=request.getSession();
		session.setAttribute("productBeanList", pb);
		response.sendRedirect("AddProduct.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		Date dom = null,doe = null;
		String pname=request.getParameter("Product_Name");
		//String pimage=request.getParameter("pic");
		String item=request.getParameter("Item");
		String dm=request.getParameter("Manufacture");
		String de=request.getParameter("Expiry");
		System.out.println(pname+item+dm+de);
		
		try {
		dom=new SimpleDateFormat("yyyy-MM-dd").parse(dm);  
		doe=new SimpleDateFormat("yyyy-MM-dd").parse(de); 
			 System.out.println(dom+" "+doe);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String location=request.getParameter("location");
		InputStream inputStream = null; 
        Part filePart = request.getPart("pic");
        if (filePart != null) {
            inputStream = filePart.getInputStream();
            System.out.println("in filePart != null");
        }
		System.out.println(dom+" "+doe);
		
		int price = Integer.parseInt(request.getParameter("product_price"));
		float rating = Float.parseFloat(request.getParameter("Rating"));
		ProductBean pb=new ProductBean(pname,inputStream,Integer.parseInt(item),dom,doe,price,location,rating);
		HttpSession session=request.getSession();
		ProductService ps=new ProductServiceImpl();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		if(ps.addProduct(pb))
		{
			ArrayList<ProductBean> pw=new ArrayList<ProductBean>();
			pw.add(pb);
			session.setAttribute("products",pw);
		
			request.getRequestDispatcher("EditProduct.jsp").forward(request, response);
		}
		else
		{
			//request.setAttribute("errMessage",addProduct);
			request.getRequestDispatcher("AddProduct.jsp").include(request,response);
			
		}

	}

}
