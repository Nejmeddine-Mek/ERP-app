package views.models;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ProductView {
	private static int IDGen = 1;
	private SimpleIntegerProperty id;
	private SimpleStringProperty description;
	private SimpleIntegerProperty quantity;
	private SimpleFloatProperty sellingPrice;
	private SimpleFloatProperty buyingPrice;
	private SimpleFloatProperty subTotal;
	public ProductView(String description, float sellP,float buyP) {
		this.id = new SimpleIntegerProperty();
		this.id.set(IDGen++);
		this.description = new SimpleStringProperty();
		this.description.set(description);
		this.buyingPrice = new SimpleFloatProperty();
		this.buyingPrice.set(buyP);
		this.sellingPrice = new SimpleFloatProperty();
		this.sellingPrice.set(sellP);
		this.quantity = new SimpleIntegerProperty();
		this.quantity.set(1);
		this.subTotal = new SimpleFloatProperty();
		this.subTotal.set(sellP);
	}
	public SimpleStringProperty descriptionProperty() {
		return this.description;
	}
	public SimpleFloatProperty sellinPriceProperty() {
		return this.sellingPrice;
	}
	public SimpleFloatProperty subTotalProperty() {
		return this.subTotal;
	}
	public SimpleIntegerProperty quantityProperty() {
		return this.quantity;
	}
	public SimpleIntegerProperty idProperty() {
		return this.id;
	}
}

