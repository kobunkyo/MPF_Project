package model;

public class Item {
	private Integer price;
	private String name;
	private Integer stock;
	private String description;
	private String imageURL;
	
	public Item(Integer price, String name, Integer stock, String description, String imageURL) {
		super();
		this.price = price;
		this.name = name;
		this.stock = stock;
		this.description = description;
		this.imageURL = imageURL;
	}
	
	public void setStockCheckOut(int quantity) {
		this.stock -= quantity;
	}
	
	public Integer getPrice() {
		return price;
	}
	
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getStock() {
		return stock;
	}
	
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImageURL() {
		return imageURL;
	}
	
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
}
