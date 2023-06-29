package jp.co.aforce.beans;

public class CartBean implements java.io.Serializable{
	private String productId;
	private String productName;
	private String imagePass;
	private int price;
	private int purchaseNumber;
	
	
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
	public int getPurchaseNumber() {
		return purchaseNumber;
	}
	public void setPurchaseNumber(int purchaseNumber) {
		this.purchaseNumber = purchaseNumber;
	}
	
	
	
	
}
