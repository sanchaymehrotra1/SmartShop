package com.cogni.smart_shop.service;

import com.cogni.smart_shop.bean.LoginBean;
import com.cogni.smart_shop.dao.LoginDao;
import com.cogni.smart_shop.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService{

	@Override
	public boolean validateUser(LoginBean bean, String userType) {
		// TODO Auto-generated method stub
		LoginDao ld=new LoginDaoImpl();
		return ld.validateUser(bean, userType);
	}

}
