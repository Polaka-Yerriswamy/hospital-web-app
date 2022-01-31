package com.ty.hospital.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dto.Person;


public class PersonDao {


	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction;
	
	public void createPerson(Person person)
	{
		entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		
		entityManager.persist(person);
		entityTransaction.commit();
}
	
	
	public List<Person> getAllPersons()
	{
		Query query=entityManager.createQuery("Select p from Person p");
		return query.getResultList();
	}
	
	
	public boolean deletePerson(int id) {
		entityTransaction =entityManager.getTransaction();
		
		Person person= entityManager.find(Person .class, id);
		if(person !=null) {
			entityTransaction.begin();
			entityManager.remove(person);
			entityTransaction.commit();
			return true;
			
		}else {
			return false;
		}
	}
	

	public Person getPersonById(int id)
	{
		return entityManager.find(Person.class, id);
	}
	
	
	
	public void updatePerson(Person person)
	{
		entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		entityManager.merge(person);

		entityTransaction.commit();
}
}