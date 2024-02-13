package com.ty.hospita_app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
	private int adressId;
	private String name;
	private String districtName;
	private String stateName;
	private String landMark;
	private int pin;
	public Address() {}
	public Address(int adressId, String name, String districtName, String stateName, String landMark, int pin) {
		super();
		this.adressId = adressId;
		this.name = name;
		this.districtName = districtName;
		this.stateName = stateName;
		this.landMark = landMark;
		this.pin = pin;
	}
	public int getAdressId() {
		return adressId;
	}
	public void setAdressId(int adressId) {
		this.adressId = adressId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getLandMark() {
		return landMark;
	}
	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	

}
