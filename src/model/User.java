package model;

public class User {
	private String name;
	private String email;
	private String password;
	private Integer[] quantity = {0, 0, 0, 0, 0};
	private Integer coin;
	private int[] cartQuantity = {0, 0, 0, 0, 0};
	private int totalPrice;
	
	public User(String name, String email, String password, Integer coin) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.coin = coin;
		this.totalPrice = 0;
	}
	
	public void setTotalPrice(int price) {
		this.totalPrice += price;
	}
	
	public void resetCart() {
		for(int i = 0; i < cartQuantity.length; i++) {
			cartQuantity[i] = 0;
		}
		totalPrice = 0;
	}
	
	public void setInventory() {
		for (int i = 0; i < quantity.length; i++) {
			quantity[i] += cartQuantity[i];
		}
	}
	
	public int getTotalPrice() {
		return totalPrice;
	}
	
	public int[] getCart() {
		return cartQuantity;
	}
	
	public void setItemQuantity1(int qty) {
		this.cartQuantity[0]++;
	}
	
	public int getItemQuantity1() {
		return cartQuantity[0];
	}
	
	public void setItemQuantity2(int qty) {
		this.cartQuantity[1]++;
	}
	
	public int getItemQuantity2() {
		return cartQuantity[1];
	}
	
	public void setItemQuantity3(int qty) {
		this.cartQuantity[2]++;
	}
	
	public int getItemQuantity3() {
		return cartQuantity[2];
	}
	
	public void setItemQuantity4(int qty) {
		this.cartQuantity[3]++;
	}
	
	public int getItemQuantity4() {
		return cartQuantity[3];
	}
	
	public void setItemQuantity5(int qty) {
		this.cartQuantity[4]++;
	}
	
	public int getItemQuantity5() {
		return cartQuantity[4];
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getCoin() {
		return coin;
	}
	
	public void setCoin(Integer coin) {
		this.coin -= coin;
	}
	
	public Integer[] getQuantity() {
		return this.quantity;
	}
	
	public void setQty1() {
		this.quantity[0]--;
	}
	
	public void setQty2() {
		this.quantity[1]--;
	}
	
	public void setQty3() {
		this.quantity[2]--;
	}
	
	public void setQty4() {
		this.quantity[3]--;
	}
	
	public void setQty5() {
		this.quantity[4]--;
	}
}
