package com.ty.hospita_app.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {
	@Id
	private int personId;
	private String name;
	private String bloodGroup;
	private String accompanyName;
	private String accompanyRelation;
	private int noOfVisits;
	@OneToMany
	private List<Encounter> encounters;
	public List<Encounter> getEncounters() {
		return encounters;
	}
	public void setEncounters(List<Encounter> encounters) {
		this.encounters = encounters;
	}
	
	public Person(int personId, String name, String bloodGroup, String accompanyName, String accompanyRelation,
			int noOfVisits, List<Encounter> encounters) {
		super();
		this.personId = personId;
		this.name = name;
		this.bloodGroup = bloodGroup;
		this.accompanyName = accompanyName;
		this.accompanyRelation = accompanyRelation;
		this.noOfVisits = noOfVisits;
		this.encounters = encounters;
	}
	public Person() {}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getAccompanyName() {
		return accompanyName;
	}
	public void setAccompanyName(String accompanyName) {
		this.accompanyName = accompanyName;
	}
	public String getAccompanyRelation() {
		return accompanyRelation;
	}
	public void setAccompanyRelation(String accompanyRelation) {
		this.accompanyRelation = accompanyRelation;
	}
	public int getNoOfVisits() {
		return noOfVisits;
	}
	public void setNoOfVisits(int noOfVisits) {
		this.noOfVisits = noOfVisits;
	}
	
	

}
