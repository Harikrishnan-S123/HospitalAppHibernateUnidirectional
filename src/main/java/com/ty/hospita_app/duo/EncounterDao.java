package com.ty.hospita_app.duo;

import java.util.ArrayList;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospita_app.entity.Encounter;
import com.ty.hospita_app.entity.MedOrders;
import com.ty.hospita_app.entity.Person;

public class EncounterDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	Scanner scanner=new Scanner(System.in);
	public  Encounter saveEncounter(Encounter encounter) {
		System.out.println("Enter encounterid");
		int encounterId=scanner.nextInt();
		encounter.setEncounterId(encounterId);
		System.out.println("Enter Admission date");
		String admsissionDate=scanner.next();
		encounter.setAdmissionDate(admsissionDate);
		System.out.println("Enter visited doctor name");
		String doctorName=scanner.next();
		encounter.setVistedDoctor(doctorName);
		System.out.println("Enter disease name");
		String diseaseName=scanner.next();
		encounter.setDiseaseName(diseaseName);
		System.out.println("Enter number of tests conducted");
		int noOfTests=scanner.nextInt();
		encounter.setNoOfTest(noOfTests);
		entityTransaction.begin();
		entityManager.persist(encounter);
		entityTransaction.commit();
		encounter.setMedOrders(new ArrayList<MedOrders>());
		return encounter;
		
	}
	public Person savePerson(Person person) {
		System.out.println("Enter id");
		int personId=scanner.nextInt();
		System.out.println("Enter name");
		String name=scanner.next();
		System.out.println("Enter blood group");
		String bloodGroup=scanner.next();
		System.out.println("Enter accompany name");
		String accompanyName=scanner.next();
		System.out.println("Enter accompany relation");
		String accompanyRelation=scanner.next();
		System.out.println("Enter number of visits");
		int noOfisits=scanner.nextInt();
		person=new Person(personId, name, bloodGroup, accompanyName, accompanyRelation, noOfisits,null);
		System.out.println(person.getEncounters());
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
		return person;
		
		
	}
	
	
	public Encounter findEncounter(int id) {
		return entityManager.find(Encounter.class,id);
	}
	public Person findPerson(int id) {
		return entityManager.find(Person.class,id);
	}
	
	

}
