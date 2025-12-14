package views.models;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ClientModelView {
	private SimpleStringProperty name;
	private SimpleIntegerProperty id;
	private SimpleFloatProperty depts;
	private SimpleStringProperty phone;
	private SimpleIntegerProperty transactions;
	
	public ClientModelView(String name, int id, float depts,
			String phone, int transactions) {
		this.name = new SimpleStringProperty(name);
		this.id = new SimpleIntegerProperty(id);
		this.phone = new SimpleStringProperty(phone);
		this.depts = new SimpleFloatProperty(depts);
		this.transactions = new SimpleIntegerProperty(transactions);
	}
	public SimpleStringProperty getName() {
		return name;
	}
	public void setName(SimpleStringProperty name) {
		this.name = name;
	}
	public SimpleIntegerProperty getId() {
		return id;
	}
	public void setId(SimpleIntegerProperty id) {
		this.id = id;
	}
	public SimpleFloatProperty getDepts() {
		return depts;
	}
	public void setDepts(SimpleFloatProperty depts) {
		this.depts = depts;
	}
	public SimpleStringProperty getPhone() {
		return phone;
	}
	public void setPhone(SimpleStringProperty phone) {
		this.phone = phone;
	}
	public SimpleIntegerProperty getTransactions() {
		return transactions;
	}
	public void setTransactions(SimpleIntegerProperty transactions) {
		this.transactions = transactions;
	}
	
}
