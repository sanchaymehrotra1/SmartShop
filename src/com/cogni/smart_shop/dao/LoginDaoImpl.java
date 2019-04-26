package com.cogni.smart_shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cogni.smart_shop.bean.LoginBean;
import com.cogni.smart_shop.util.DBConnect;

public class LoginDaoImpl implements LoginDao {

	@Override
	public boolean validateUser(LoginBean bean, String w) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.println(bean.getUsername() + bean.getPassword() + w);
		if (w.equalsIgnoreCase("u")) {

			try {
				con = DBConnect.getConnection();
				String query = "select * from user_register where user_id=? and password=?";
				ps = con.prepareStatement(query);
				ps.setString(1, bean.getUsername());
				ps.setString(2, bean.getPassword());
				rs = ps.executeQuery();
				if (rs.next()) {
					return true;
				} else
					return false;
			}

			catch (SQLException e) {

				e.printStackTrace();
			} finally {
				DBConnect.closeConnection(con);
			}
		} else if (w.equalsIgnoreCase("M")) {
			try {
				con = DBConnect.getConnection();
				String query = "select * from admin_register where user_id=? and password=?";
				ps = con.prepareStatement(query);
				ps.setString(1, bean.getUsername());
				ps.setString(2, bean.getPassword());
				rs = ps.executeQuery();
				if (rs.next()) {
					return true;
				} else
					return false;
			}

			catch (SQLException e) {

				e.printStackTrace();
			} finally {
				DBConnect.closeConnection(con);
			}
		}
		return false;

	}

}
