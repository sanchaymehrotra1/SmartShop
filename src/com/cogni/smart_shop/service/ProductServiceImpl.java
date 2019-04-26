package com.cogni.smart_shop.service;

import java.util.List;

import com.cogni.smart_shop.bean.ProductBean;
import com.cogni.smart_shop.dao.ProductDao;
import com.cogni.smart_shop.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService{

	ProductDao pd=new ProductDaoImpl();
	@Override
	public boolean addProduct(ProductBean pb) {
		if(pd.addProduct(pb))
			return true;
		
		return false;
	}

	@Override
	public boolean deleteProduct(ProductBean pb, String name) {
	if(pd.deleteProduct(pb, name))
		return true;
		return false;
	}

	@Override
	public boolean updateProduct(String name, int item) {
		if(pd.updateProduct(name, item))
			return true;
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ProductBean> getAllProductBean() {
		ProductDao pd=new ProductDaoImpl();
		return pd.getAllProductBean();
	}

	@Override
	public List<ProductBean> sortProducts(String query) {
		ProductDao pd=new ProductDaoImpl();
		return pd.sortProducts(query);
	}

	@Override
	public List<ProductBean> searchProducts(String name) {
		ProductDao pd=new ProductDaoImpl();
		return pd.searchProducts(name);
	}

}
