package com.ty.hospital.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dto.Hospital;
import com.ty.hospital.dto.Person;


public class HospitalDao {


	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction;
	
	public void createHospital(Hospital hospital)
	{
		entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		
		entityManager.persist(hospital);
		entityTransaction.commit();
}
	
	
	public List<Hospital> getAllHospitals()
	{
		Query query=entityManager.createQuery("Select h from Hospital h");
		return query.getResultList();
	}
	
	
	public boolean deleteHospital(int id) {
		entityTransaction =entityManager.getTransaction();
		
		Hospital hospital= entityManager.find(Hospital .class, id);
		if(hospital !=null) {
			entityTransaction.begin();
			entityManager.remove(hospital);
			entityTransaction.commit();
			return true;
			
		}else {
			return false;
		}
	}
	

	public Hospital getHospitalById(int id)
	{
		return entityManager.find(Hospital.class, id);
	}
	
	
	
	public void updateHospital(Hospital hospital)
	{
		entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		entityManager.merge(hospital);

		entityTransaction.commit();
}
}