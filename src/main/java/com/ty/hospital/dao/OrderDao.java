package com.ty.hospital.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dto.Branch;
import com.ty.hospital.dto.Encounter;
import com.ty.hospital.dto.Hospital;
import com.ty.hospital.dto.Orders;
import com.ty.hospital.dto.Person;

public class OrderDao {


	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction;
	EncounterDao encounterDao=new EncounterDao();
	
	public boolean createOrder(int encounterId,Orders order)
	{
		Encounter encounter=encounterDao.getEncounterById(encounterId);
		
		if(encounter!=null )
		{
		entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		order.setEncounter(encounter);
		entityManager.persist(order);
		entityTransaction.commit();
		return true;
		}
		else
		{
			return false;
		}
		
}
	public Orders getOrderById(int id)
	{
		return entityManager.find(Orders.class, id);
	}
	public List<Orders> getAllOrders()
	{
		Query query=entityManager.createQuery("Select o from Orders o");
		return query.getResultList();
	}
}
