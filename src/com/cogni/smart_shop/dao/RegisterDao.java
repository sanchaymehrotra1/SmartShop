package com.cogni.smart_shop.dao;

import com.cogni.smart_shop.bean.Register;

public interface RegisterDao {
	
	public boolean insert(Register register,String usertype);

}
