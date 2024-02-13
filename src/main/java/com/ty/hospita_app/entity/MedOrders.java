package com.ty.hospita_app.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class MedOrders {
	@Id
	private int medOrderId;
	private int noofMedicines;
	private String invoiceNumber;
	
	private String orderDate;
	private String paymentMode;
	@ManyToMany
	private List<Item> items;
	public int getMedOrderId() {
		return medOrderId;
	}
	public void setMedOrderId(int medOrderId) {
		this.medOrderId = medOrderId;
	}
	public int getNoofMedicines() {
		return noofMedicines;
	}
	public void setNoofMedicines(int noofMedicines) {
		this.noofMedicines = noofMedicines;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public MedOrders(int medOrderId, int noofMedicines, String invoiceNumber, String orderDate, String paymentMode,
			List<Item> items) {
		super();
		this.medOrderId = medOrderId;
		this.noofMedicines = noofMedicines;
		this.invoiceNumber = invoiceNumber;
		this.orderDate = orderDate;
		this.paymentMode = paymentMode;
		this.items = items;
	}
	public MedOrders() {}

}
