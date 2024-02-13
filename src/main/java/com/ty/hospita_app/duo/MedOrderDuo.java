package com.ty.hospita_app.duo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospita_app.entity.Item;
import com.ty.hospita_app.entity.MedOrders;

public class MedOrderDuo {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	Scanner scanner=new Scanner(System.in);
	public MedOrders saveMedOrders(MedOrders medOrders) {
		System.out.println("Enter id");
		int id=scanner.nextInt();
		System.out.println("Enter number of medicine");
		int noOfMedicines=scanner.nextInt();
		System.out.println("Enter invoice number");
		String invoiceNumber=scanner.next();
		System.out.println("Enter orderdate");
		String orderDate=scanner.next();
		System.out.println("Enter payment mode");
		String paymentMode=scanner.next();
		System.out.println("Enter number of items");
		int noOfItems=scanner.nextInt();
		List<Item> items=new ArrayList<>();

		for(int i=0;i<noOfItems;i++) {
			System.out.println("Enter id");
			int itemid=scanner.nextInt();
			System.out.println("Enter name");
			String itemName=scanner.next();
			System.out.println("Enter price");
			double price=scanner.nextDouble();
			System.out.println("Enter dosage");
			String dosage=scanner.next();
			System.out.println("Enter number of days");
			String noOfDays=scanner.next();
			System.out.println("Enter expiry");
			String expiry=scanner.next();
			Item item=new Item(itemid, itemName, price, dosage, noOfDays, expiry);
			items.add(item);


		}
		medOrders=new MedOrders(id, noOfMedicines, invoiceNumber, orderDate, paymentMode, items);
		entityTransaction.begin();
		for(Item eachItem:items)
			entityManager.persist(eachItem);
		entityManager.persist(medOrders);
		entityTransaction.commit();
		//medOrders.set
		return medOrders;

	}

}
