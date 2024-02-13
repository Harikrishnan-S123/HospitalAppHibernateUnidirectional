package com.ty.hospita_app.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Encounter {
	@Id
	private int encounterId;
	private String admissionDate;
	private String vistedDoctor;
	private String diseaseName;
	private int noOfTest;
	@OneToMany
	private List<MedOrders> medOrders;

	public int getEncounterId() {
		return encounterId;
	}
	public void setEncounterId(int encounterId) {
		this.encounterId = encounterId;
	}
	public String getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}
	public String getVistedDoctor() {
		return vistedDoctor;
	}
	public void setVistedDoctor(String vistedDoctor) {
		this.vistedDoctor = vistedDoctor;
	}
	public String getDiseaseName() {
		return diseaseName;
	}
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
	public int getNoOfTest() {
		return noOfTest;
	}
	public void setNoOfTest(int noOfTest) {
		this.noOfTest = noOfTest;
	}
	public List<MedOrders> getMedOrders() {
		return medOrders;
	}
	public void setMedOrders(List<MedOrders> medOrders) {
		this.medOrders = medOrders;
	}
//	public Person getPerson() {
//		return person;
//	}
//	public void setPerson(Person person) {
//		this.person = person;
//	}


}
