package com.ty.hospita_app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {
	@Id
	private int itemId;
	private String name;
	private double price;
	private String dosage;
	private String noofDays;
	private String expiryDate;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public String getNoofDays() {
		return noofDays;
	}
	public void setNoofDays(String noofDays) {
		this.noofDays = noofDays;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Item(int itemId, String name, double price, String dosage, String noofDays, String expiryDate) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.price = price;
		this.dosage = dosage;
		this.noofDays = noofDays;
		this.expiryDate = expiryDate;
	}
	public Item() {}
	
	

}
