package com.ty.hospita_app.duo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospita_app.entity.Branch;
import com.ty.hospita_app.entity.Encounter;
import com.ty.hospita_app.entity.Hospital;
import com.ty.hospita_app.entity.MedOrders;
import com.ty.hospita_app.entity.Person;
import com.ty.hospita_app.helper.Helper;

public class HosiptalDuo {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	Scanner scanner=new Scanner(System.in);
	BranchDuo branchDuo=new BranchDuo();
	EncounterDao encounterDao=new EncounterDao();
	MedOrderDuo medOrderDuo=new MedOrderDuo();
	public Hospital saveHospital(Hospital hospital) {
		System.out.println("Enter hospitalid");
		String hospitalId=scanner.next();
		hospital.setHospitalId(hospitalId);
		System.out.println("Enter hospitalName");
		String hospitalName=scanner.next();
		hospital.setHospitalName(hospitalName);
		System.out.println("Enter founder name");
		String founderName=scanner.next();
		hospital.setFounderName(founderName);
		System.out.println("Enter total no of beds");
		int noOfBeds=scanner.nextInt();
		hospital.setNoOfBeds(noOfBeds);
		System.out.println("Enter total no of doctors");
		int noOfDoctors=scanner.nextInt();
		hospital.setNoOfDoctors(noOfDoctors);
		hospital.setBranches(new ArrayList<Branch>());
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityTransaction.commit();
		System.out.println("Hospital Registered successfully");
		Helper.forEach(hospital);
		return hospital;


	}
	public Hospital findHopsital(String hospitalId) {
		return entityManager.find(Hospital.class, hospitalId);
	}
	public Branch addBranch(Branch branch,String hospitalId) {
		//System.out.println("hi");
		Hospital hospital=findHopsital(hospitalId);
		if(hospital!=null) {
			List<Branch> branches=hospital.getBranches();
			System.out.println(branches);
			branch=branchDuo.saveBranch(branch, hospitalId);
			branches.add(branch);
			hospital.setBranches(branches);
			entityTransaction.begin();
			entityManager.merge(hospital);
			entityTransaction.commit();
		}
		else {
			System.out.println("Invalid Hospital Id");
		}
		
		return branch;


	}
	public Encounter addEncounter(Encounter encounter,int branchId,int personId) {
		Branch branch=branchDuo.findBranch(branchId);
		Person person=encounterDao.findPerson(personId);
		if(branch!=null && person!=null) {
			encounter=encounterDao.saveEncounter(encounter);
			List<Encounter> encounters1=branch.getEncounters();
			encounters1.add(encounter);
			List<Encounter> encounters2=person.getEncounters();
			//System.out.println(encounters2);
			encounters2.add(encounter);
			branch.setEncounters(encounters1);
			person.setEncounters(encounters2);
			entityTransaction.begin();
			entityManager.merge(person);
			entityManager.merge(branch);
			entityTransaction.commit();
			System.out.println("Encounter added succesfully");
			Helper.forEach(encounter, person);
		}
		else
			System.out.println("Invalid Insertion check branch id and person id again");
		
		return encounter;
		
	}
	public MedOrders createMedOrders(MedOrders medOrders,int encounterId) {
		Encounter encounter=encounterDao.findEncounter(encounterId);
		if(encounter!=null) {
			medOrders=medOrderDuo.saveMedOrders(medOrders);
			List<MedOrders> medOrderslist=encounter.getMedOrders();
			medOrderslist.add(medOrders);
			encounter.setMedOrders(medOrderslist);
			entityTransaction.begin();
			entityManager.merge(encounter);
			entityTransaction.commit();
			System.out.println("Medorder Added");

		}
		else {
			System.out.println("Invalid Insertion since encounter id is missing");
		}
		return medOrders;
		
	}
	
	public void finalTasks(Scanner scanner) {
		this.scanner.close();
		encounterDao.scanner.close();
		branchDuo.scanner.close();
		scanner.close();
	}

}
