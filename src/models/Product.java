package models;

import java.time.LocalDateTime;

public class Product {
	private int id;
	private String barCode;
	private String description;
	private String category;
	private float selling_price;
	private float buying_price;
	private int stock;
	private boolean hasDiscount;
	private int discountQ;
	private float discountPrice;
	LocalDateTime createdOn;
	LocalDateTime updatedOn;
	public Product(int id, String bc, String description,String c, float bp, float sp, boolean hasDiscount, int disq, float discp
			, LocalDateTime co, LocalDateTime uo) {
		this.id = id;
		barCode = bc;
		this.description = description;
		this.category = c;
		this.selling_price = sp;
		this.buying_price = bp;
		this.stock = 0;
		this.hasDiscount = hasDiscount;
		this.discountQ = disq;
		this.discountPrice = discp;
		this.createdOn = co;
		this.updatedOn = uo;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setSellingPrice(float sell) {
		this.selling_price = sell;
	}
	public void setBuyingPrice(float buy) {
		this.buying_price = buy;
	}
	public void setBarCode(String bc) {
		this.barCode = bc;
	}
	public void setDiscount(int dq, float dp ) {
		this.hasDiscount = true;
		this.discountQ = dq;
		this.discountPrice = dp;
	}
	public void setStock(int stk) {
		this.stock = stk;
	}
	public int getStock() {
		return this.stock;
	}
	public void addToStock(int val) {
		this.stock += val;
	}
	
	public String getBarCode() {
		return this.barCode;
	}
	public String getDescription() {
		return this.description;
	}
	public float getSellingPrice() {
		return this.selling_price;
	}
	public float getBuyingPrice() {
		return this.buying_price;
	}
	public boolean hasDiscount() {
		return this.hasDiscount;
	}
	public int getDiscountQuantity() {
		if(this.hasDiscount)
			return this.discountQ;
		else
			return 0;
	}
	public float getDiscountPrice() {
		if(this.hasDiscount)
			return this.discountPrice;
		else
			return 0;
	}


	
	
}
