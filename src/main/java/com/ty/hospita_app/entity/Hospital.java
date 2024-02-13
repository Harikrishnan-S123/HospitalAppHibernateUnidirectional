package com.ty.hospita_app.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hospital {
	@Id
	private String hospitalId;
	private String hospitalName;
	private String founderName;
	private int noOfDoctors;
	private int noOfBeds;
	@OneToMany
	private List<Branch> branches;
	
	public List<Branch> getBranches() {
		return branches;
	}
	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}
	public String getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String name) {
		this.hospitalName = name;
	}
	public String getFounderName() {
		return founderName;
	}
	public void setFounderName(String founderName) {
		this.founderName = founderName;
	}
	public int getNoOfDoctors() {
		return noOfDoctors;
	}
	public void setNoOfDoctors(int noOfDoctors) {
		this.noOfDoctors = noOfDoctors;
	}
	public int getNoOfBeds() {
		return noOfBeds;
	}
	public void setNoOfBeds(int noOfBeds) {
		this.noOfBeds = noOfBeds;
	}
	
	
	

}
