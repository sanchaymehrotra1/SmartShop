package com.cogni.smart_shop.bean;

import java.io.InputStream;
import java.util.Date;

public class ProductBean {
	
	private String product_name;
	private InputStream product_image;
	private int noi;
	private Date dom;
	private Date doe;
	private int price;
	private String location;
	private float rating;
	public ProductBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductBean(String product_name, InputStream product_image, int noi, Date dom, Date doe, int price,
			String location, float rating) {
		super();
		this.product_name = product_name;
		this.product_image = product_image;
		this.noi = noi;
		this.dom = dom;
		this.doe = doe;
		this.price = price;
		this.location = location;
		this.rating = rating;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public InputStream getProduct_image() {
		return product_image;
	}
	public void setProduct_image(InputStream product_image) {
		this.product_image = product_image;
	}
	public int getNoi() {
		return noi;
	}
	public void setNoi(int noi) {
		this.noi = noi;
	}
	public Date getDom() {
		return dom;
	}
	public void setDom(Date dom) {
		this.dom = dom;
	}
	public Date getDoe() {
		return doe;
	}
	public void setDoe(Date doe) {
		this.doe = doe;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	
	
}
