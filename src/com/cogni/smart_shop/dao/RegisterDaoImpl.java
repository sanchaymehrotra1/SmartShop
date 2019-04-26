package com.cogni.smart_shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cogni.smart_shop.bean.Register;
import com.cogni.smart_shop.util.DBConnect;



public class RegisterDaoImpl implements RegisterDao{

	@Override
	public boolean insert(Register register,String w) {
		
		//System.out.println(register.getF_name()+register.getL_name()+register.getAge()+register.getGender()+register.getC_number()+register.getUser_id()+register.getPassword()+w);
		
		Connection con=null;
		PreparedStatement ps = null;
		con=DBConnect.getConnection();
		try
		{
		if(w.equalsIgnoreCase("u"))
		{
		String query="insert into user_register(First_Name,Last_Name,Age,Gender,Contact_number,user_id,password) values (?,?,?,?,?,?,?)";
		ps=con.prepareStatement(query);
		ps.setString(1, register.getF_name());
		ps.setString(2, register.getL_name());
		ps.setInt(3, register.getAge());
		ps.setString(4,register.getGender());
		ps.setLong(5,register.getC_number());
		ps.setString(6, register.getUser_id());
		ps.setString(7, register.getPassword());
		int i=ps.executeUpdate();
		if(i!=0)
		{
			return true;
		}
		}
		else if((w.equalsIgnoreCase("m")))
				{
			String query="insert into admin_register(First_Name,Last_Name,Age,Gender,Contact_number,user_id,password) values (?,?,?,?,?,?,?)";
			ps=con.prepareStatement(query);
			ps.setString(1, register.getF_name());
			ps.setString(2, register.getL_name());
			ps.setInt(3, register.getAge());
			ps.setString(4,register.getGender());
			ps.setLong(5,register.getC_number());
			ps.setString(6, register.getUser_id());
			ps.setString(7, register.getPassword());
			int i=ps.executeUpdate();
			if(i!=0)
			{
				return true;
			}
			
				}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			
			 DBConnect.closeConnection(con);
				
			
		}
		
		// TODO Auto-generated method stub
		return false;
	}

}
