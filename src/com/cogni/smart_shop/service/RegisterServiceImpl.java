package com.cogni.smart_shop.service;

import com.cogni.smart_shop.bean.Register;
import com.cogni.smart_shop.dao.RegisterDao;
import com.cogni.smart_shop.dao.RegisterDaoImpl;

public class RegisterServiceImpl implements RegisterService{

	@Override
	public boolean insert(Register bean,String w) {
		
		RegisterDao rd=new RegisterDaoImpl();
		if(rd.insert(bean, w)==true)
			return true;
		// TODO Auto-generated method stub
		return false;
		
	}

}
