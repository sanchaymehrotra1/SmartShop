package com.cogni.smart_shop.dao;

import com.cogni.smart_shop.bean.LoginBean;

public interface LoginDao {
	
		public boolean validateUser(LoginBean bean,String usertype);
}
