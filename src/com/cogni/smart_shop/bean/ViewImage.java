package com.cogni.smart_shop.bean;

public class ViewImage {

	private String id;
    private String name;
    private byte[] imageData;
    private String imageFileName;
	public ViewImage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ViewImage(String id, String name, byte[] imageData, String imageFileName) {
		super();
		this.id = id;
		this.name = name;
		this.imageData = imageData;
		this.imageFileName = imageFileName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getImageData() {
		return imageData;
	}
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
 
	
}
