package jp.co.aforce.beans;

public class ProductBean { 
	
	private String productId;
	private String productName;
	private int stock;
	private String imagePass;
	private int price;
	private String productCategory;
	private int purchaseNumber;
	
	
	public int getPurchaseNumber() {
		return purchaseNumber;
	}
	public void setPurchaseNumber(int number) {
		this.purchaseNumber = number;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getImagePass() {
		return imagePass;
	}
	public void setImagePass(String imagePass) {
		this.imagePass = imagePass;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	
	

}
