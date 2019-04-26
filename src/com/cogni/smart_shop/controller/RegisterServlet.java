package com.cogni.smart_shop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cogni.smart_shop.bean.Register;
import com.cogni.smart_shop.service.RegisterService;
import com.cogni.smart_shop.service.RegisterServiceImpl;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public RegisterServlet() {
        super();
        
    }



	
	
	  protected void doPost(HttpServletRequest request, HttpServletResponse
	  response) throws ServletException, IOException {

	 String f_name=request.getParameter("First_Name");
		String l_name=request.getParameter("Last_Name");
		int age=Integer.parseInt(request.getParameter("Age"));
		String gender=request.getParameter("Gender");
		String c_number=request.getParameter("cnumber");
		String userid=request.getParameter("Email");
		String password=request.getParameter("password");
		String usertype=request.getParameter("userType");
		System.out.println(usertype);
		//System.out.println(f_name+l_name+age+gender+c_number+ userid+password);
		Register rs=new Register(f_name,l_name,age,gender,Long.parseLong(c_number),userid,password);
		RegisterService rs1=new RegisterServiceImpl();
		if(rs1.insert(rs, usertype)==true)
		{
			String info="User Added Successfully";
			request.setAttribute("info",info);
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		}
		else
		{
			String info="Email Id Already Exists";
			request.setAttribute("info", info);
			request.getRequestDispatcher("Register.jsp").include(request, response);
		}
	 
	  }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 String usertype=request.getParameter("userType");
			  response.sendRedirect("Register.jsp?userType="+usertype); 
			
		}
	 
}
