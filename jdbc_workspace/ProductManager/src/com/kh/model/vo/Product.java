package com.kh.model.vo;

public class Product {

	// 필드
	private String productId;
	private String pName;
	private int price;
	private String description;
	private int stock;
	
	// 기본생성자
	public Product() {}

	// 매개변수 생성자
	public Product(String productId, String pName, int price, String description, int stock) {
		this.productId = productId;
		this.pName = pName;
		this.price = price;
		this.description = description;
		this.stock = stock;
		
	}
	
	// setter / getter메소드
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public String getProductId() {
		return productId;
	}
	
	public void setpName(String pName) {
		this.pName = pName;
	}
	
	public String getpName() {
		return pName;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public int getStock() {
		return stock;
	}
	
	
	// toString 메소드
	@Override
	public String toString() {
		return productId + ", " + pName + ", " + price + ", " + description + ", " + stock;
	}
	
	
	
	
	
}
