package com.ty.hospita_app.dco;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.ty.hospita_app.duo.BranchDuo;
import com.ty.hospita_app.duo.EncounterDao;
import com.ty.hospita_app.duo.HosiptalDuo;
import com.ty.hospita_app.entity.Branch;
import com.ty.hospita_app.entity.Encounter;
import com.ty.hospita_app.entity.Hospital;
import com.ty.hospita_app.entity.MedOrders;
import com.ty.hospita_app.entity.Person;
import com.ty.hospita_app.helper.Helper;

public class HospitalController {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Welcome to the Hospital Application");
		boolean flag=true;
		HosiptalDuo hospitaldau=new HosiptalDuo();
		try {
		while(flag) {
			System.out.println("Enter your choice");
			System.out.println("1.Register Hospital\n2.Add Branch\n3.Add a new person\n4.Encounter Operations\n5.Add Medorders\n6.Exit");
			switch(scanner.nextInt()) {
			case 1:{
				hospitaldau.saveHospital(new Hospital());
			}
			break;
			case 2:{

				String hospitalId=Helper.getHospitalId(scanner);
				hospitaldau.addBranch(new Branch(), hospitalId);
			}
			break;
			case 3:{

				(new EncounterDao()).savePerson(new Person());
			}
			break;
			case 4:{

				int branchId=Helper.getBranchId(scanner);
				int personId=Helper.getPersonId(scanner);
				hospitaldau.addEncounter(new Encounter(), branchId, personId);
			}
			break;
			case 5:{
				
				int encounterId=Helper.getEncounterId(scanner);
				hospitaldau.createMedOrders(new MedOrders(), encounterId);
			}
			break;
			case 6:{
				System.out.println("Thanks for choosing us");
				flag=false;
			}
			break;

			default:{
				System.out.println("Invalid option");
			}
			}
		}
		}
		catch (InputMismatchException e) {
			System.out.println("sorry invalid choice");
			System.out.println("Taking you back......");
			main(args);
		}
		hospitaldau.finalTasks(scanner);
	}

}
