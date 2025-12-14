package models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Client {
	private int id;
	private String nameString;
	private String phone;
	private float dept;
	private int transactions;
	private ArrayList<LocalDate> transactionsDates;
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;
	
	public Client(int id, String nameString, String phone, float dept, int transactions, LocalDateTime createdOn,
			LocalDateTime updatedOn) {
		this.id = id;
		this.nameString = nameString;
		this.phone = phone;
		this.dept = dept;
		this.transactions = transactions;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.transactionsDates = new ArrayList<>();
	}
	public Client(int id, String nameString, String phone, float dept, int transactions, LocalDateTime createdOn,
			LocalDateTime updatedOn, ArrayList<LocalDate> transactionDates) {
		this.id = id;
		this.nameString = nameString;
		this.phone = phone;
		this.dept = dept;
		this.transactions = transactions;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.transactionsDates = transactionDates;
	}
	
	public Client(int id, String nameString, String phone, float dept, int transactions) {
		this.id = id;
		this.nameString = nameString;
		this.phone = phone;
		this.dept = dept;
		this.transactions = transactions;
		this.createdOn = LocalDateTime.now();
		this.updatedOn = LocalDateTime.now();
		this.transactionsDates = new ArrayList<>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
		this.updatedOn = LocalDateTime.now();
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
		this.updatedOn = LocalDateTime.now();
	}
	public float getDept() {
		return dept;
	}
	public void setDept(float dept) {
		this.dept = dept;
		this.updatedOn = LocalDateTime.now();
	}
	public int getTransactions() {
		return transactions;
	}
	public void setTransactions(int transactions) {
		this.transactions = transactions;
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
	public void addtransaction(LocalDate td) {
		if(!this.transactionsDates.contains(td))
			this.transactionsDates.add(td);
		this.transactions += 1;
		this.updatedOn = LocalDateTime.now();
	}
	public ArrayList<LocalDate> getTransactionDates(){
		return this.transactionsDates;
	}
	
}
