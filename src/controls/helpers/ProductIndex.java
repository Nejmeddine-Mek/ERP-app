package controls.helpers;

public class ProductIndex {
	private int id;
	private String code;
	private String description;
	private float buyingPrice;
	private float sellingPrice;
	private boolean hasDiscount;
	private int discountQ;
	private float discountPrice;
	
	public ProductIndex(int id, String code, String description, float buyingPrice, float sellingPrice, boolean hasDiscount,
			int discountQ, float discountPrice) {
		this.id = id;
		this.code = code;
		this.description = description;
		this.buyingPrice = buyingPrice;
		this.sellingPrice = sellingPrice;
		this.hasDiscount = hasDiscount;
		this.discountQ = discountQ;
		this.discountPrice = discountPrice;
	}
	
}
