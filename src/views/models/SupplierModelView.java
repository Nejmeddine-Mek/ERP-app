package views.models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class SupplierModelView {
	private SimpleIntegerProperty id;
	private SimpleStringProperty name;
	private SimpleStringProperty phone;
	private SimpleStringProperty company;
	private SimpleStringProperty isActive;
	private SimpleIntegerProperty invoices;
	private SimpleDoubleProperty depts;
	
	public SupplierModelView(int id, String name, String company, String phone, boolean isActive, int invoices, double depts) {
		this.id = new SimpleIntegerProperty(id);
		this.invoices = new SimpleIntegerProperty(invoices);
		this.company = new SimpleStringProperty(company);
		this.name = new SimpleStringProperty(name);
		this.phone = new SimpleStringProperty(phone);
		this.depts = new SimpleDoubleProperty(depts);
		this.isActive = new SimpleStringProperty(isActive ? "YES":"NO");
	}
	
	public SimpleIntegerProperty getId() {
		return id;
	}
	// one cannot change the id of a supplier as it is system decided
	
	public SimpleStringProperty getName() {
		return name;
	}
	public void setName(String name) {
		this.name.set(name);
	}
	
	public SimpleStringProperty getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company.set(company);
	}
	
	public SimpleStringProperty getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive.set(isActive);
	}
	
	public SimpleIntegerProperty getInvoices() {
		return invoices;
	}
	public void setInvoices(int invoices) {
		this.invoices.set(invoices);
	}
	
	public SimpleDoubleProperty getDepts() {
		return depts;
	}
	public void setDepts(double depts) {
		this.depts.set(depts);
	}

	public SimpleStringProperty getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone.set(phone);
	}
	
}
