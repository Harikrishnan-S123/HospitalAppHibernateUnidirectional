package com.ty.hospita_app.helper;

import java.util.Scanner;

import com.ty.hospita_app.entity.Encounter;
import com.ty.hospita_app.entity.Hospital;
import com.ty.hospita_app.entity.Person;

public class Helper {
	
	public static  void forEach(Hospital hospital) {
		if(hospital!=null) {
			System.out.println("Id:  "+hospital.getHospitalId());
			System.out.println("Name: "+hospital.getHospitalName());
			System.out.println("Founder: :"+hospital.getFounderName());
			System.out.println("No of Beds: :"+hospital.getNoOfBeds());
			System.out.println("No of doctors"+hospital.getNoOfBeds());
		}
		else
			System.out.println("Invalid Insertion");
		
	}
	public static  void forEach(Encounter encounter,Person person) {
		System.out.println("------------------------Person Basic Details ----------------------");
		System.out.println("Id: "+person.getPersonId());
		System.out.println("Name: "+person.getName());
		System.out.println("NO of visits"+person.getNoOfVisits());
		System.out.println("------------------------Encounter Details----------------------");
		System.out.println("Id:  "+encounter.getEncounterId());
		System.out.println("Disease Name: "+encounter.getDiseaseName());
		System.out.println("Visited Doctor: :"+encounter.getVistedDoctor());
		System.out.println("No of tests: :"+encounter.getNoOfTest());
		System.out.println("Admission Date:"+encounter.getAdmissionDate());
		System.out.println("-----------------------------------------");
		
	}
	public static String getHospitalId(Scanner scanner) {
		System.out.println("Enter hospital id");
		return scanner.next();
	}
	public static int getBranchId(Scanner scanner) {
		System.out.println("Enter branch id");
		return scanner.nextInt();
	}
	public static int getPersonId(Scanner scanner) {
		System.out.println("Enter person id");
		return scanner.nextInt();
	}
	public static int getEncounterId(Scanner scanner) {
		System.out.println("Enter encounter id");
		return scanner.nextInt();
	}

}
