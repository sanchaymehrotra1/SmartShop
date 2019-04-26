package com.cogni.smart_shop.service;

import com.cogni.smart_shop.bean.LoginBean;

public interface LoginService {
	
	public boolean validateUser(LoginBean bean,String userType);

}
