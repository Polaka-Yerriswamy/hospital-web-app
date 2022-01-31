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
import com.ty.hospital.dto.Items;
import com.ty.hospital.dto.Orders;
import com.ty.hospital.dto.Person;

public class ItemDao {


	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction;
	OrderDao orderDao=new OrderDao();
	
	public boolean createItem(int orderId,Items item)
	{
		Orders order=orderDao.getOrderById(orderId);
		
		if(order !=null )
		{
		entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		item.setOrders(order);
		entityManager.persist(item);
		entityTransaction.commit();
		return true;
		}
		else
		{
			return false;
		}
		
}
	public Items getItemById(int id)
	{
		return entityManager.find(Items.class, id);
	}

	public List<Items> getAllItems()
	{
		Query query=entityManager.createQuery("Select i from Items i");
		return query.getResultList();
	}
}
