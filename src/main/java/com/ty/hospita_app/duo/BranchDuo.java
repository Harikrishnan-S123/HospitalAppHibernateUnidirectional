package com.ty.hospita_app.duo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospita_app.entity.Address;
import com.ty.hospita_app.entity.Branch;

public class BranchDuo {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	Scanner scanner=new Scanner(System.in);
	//HosiptalDuo duo=new HosiptalDuo();
	public Branch saveBranch(Branch branch,String hospitalId) {
			System.out.println("Enter branch id");
			int branchId=scanner.nextInt();
			branch.setBranchId(branchId);
			System.out.println("Enter branch name");
			String branchName=scanner.next();
			branch.setBranchName(branchName);
			System.out.println("Enter branch head name");
			String branchHeadName=scanner.next();
			branch.setBranchHeadName(branchHeadName);
			System.out.println("Enter branch start year");
			int startYear=scanner.nextInt();
			branch.setYearOfStart(startYear);
			System.out.println("Enter number of devices in your branch");
			int noOfDevices=scanner.nextInt();
			branch.setNoOfDevices(noOfDevices);
			System.out.println("Enter address id");
			int addressId=scanner.nextInt();
			System.out.println("Enter address location name");
			String addressName=scanner.next();
			System.out.println("Enter district name");
			String districtName=scanner.next();
			System.out.println("Enter state name");
			String stateName=scanner.next();
			System.out.println("Enter landmark");
			String landmark=scanner.next();
			System.out.println("Enter pin");
			int pin=scanner.nextInt();
			Address address=new Address(addressId, addressName, districtName, stateName, landmark, pin);
			branch.setAddress(address);
			entityTransaction.begin();
			entityManager.persist(address);
			entityManager.persist(branch);
			entityTransaction.commit();
			System.out.println(branchId+"Branch saved successfully");
		
		
		
		return branch;
		
	}
	public Branch findBranch(int branchId) {
		return entityManager.find(Branch.class, branchId);
	}

}
