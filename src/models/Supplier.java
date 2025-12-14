package models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Supplier {
	private int id;
	private String name;
	private String company;
	private String phone;
	private int invoices;
	private double depts;
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;
	private boolean isActive;
	private String email; // this is totally optional
	private ArrayList<Integer> invoicesId;
	// also add the link to invoices here later
	
	public Supplier(int id, String name, String company, String phone, int invoices, double depts, boolean isActive, String email) {
		this.id = id;
		this.name = name;
		this.company = company;
		this.phone = phone;
		this.invoices = invoices;
		this.depts = depts;
		this.isActive = isActive;
		this.email = email;
		this.createdOn = LocalDateTime.now();
		this.updatedOn = LocalDateTime.now();
		this.invoicesId = new ArrayList<>();
	}
	
	
	// ===== Getters and setters ===== 
	public int getId() {
		return id;
	} 
	// the id is not editable
	public String getName() { 
		return name; 
	} 
	public void setName(String name) { 
		this.name = name; 
		this.updatedOn = LocalDateTime.now(); 
	} 
	public String getCompany() {
		return company;
	} 
	public void setCompany(String company) { 
		this.company = company; 
		this.updatedOn = LocalDateTime.now(); 
	}
	public String getPhone() { 
		return phone; 
	} 
	public void setPhone(String phone) { 
		this.phone = phone; 
		this.updatedOn = LocalDateTime.now(); 
	} 
	public int getInvoices() {
		return invoices; 
	} 
	public void setInvoices(int invoices) {
		this.invoices = invoices; 
		this.updatedOn = LocalDateTime.now();
	} 
	public double getDepts() { 
		return depts;
	}
	public void setDepts(double depts) { 
		this.depts = depts;
		this.updatedOn = LocalDateTime.now(); 
	} 
	public LocalDateTime getCreatedOn() {
		return createdOn;
	} 
	public void setCreatedOn(LocalDateTime createdOn) { 
		this.createdOn = createdOn; 
	} 
	public LocalDateTime getUpdatedOn() { 
		return updatedOn; 
	} 
	public void setUpdatedOn(LocalDateTime updatedOn) { 
		this.updatedOn = updatedOn;
	} 
	public boolean isActive() { 
		return isActive;
	} 
	public void setActive(boolean active) { 
		isActive = active; 
		this.updatedOn = LocalDateTime.now(); 
	} 
	public String getEmail() { 
		return email; 
	} 
	public void setEmail(String email) { 
		this.email = email; 
		this.updatedOn = LocalDateTime.now();
	} 
	public ArrayList<Integer> getInvoicesId() { 
		return invoicesId; 
	} 
	// ===== Methods for managing invoices ===== 
	public void addInvoice(int invoiceId) { 
		if (!invoicesId.contains(invoiceId)) {
			invoicesId.add(invoiceId); 
			invoices++; 
			this.updatedOn = LocalDateTime.now(); 
		} 
	} 
	public void removeInvoice(int invoiceId) { 
		if (invoicesId.remove((Integer) invoiceId)) { 
			invoices--;
			this.updatedOn = LocalDateTime.now(); 
			} 
	}
}
