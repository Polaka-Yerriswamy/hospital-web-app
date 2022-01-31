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
import com.ty.hospital.dto.Person;

public class EncounterDao {


	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction;
	PersonDao personDao=new PersonDao();
	BranchDao branchDao=new BranchDao();
	
	public boolean createEncounter(int branchId,int personId,Encounter encounter)
	{
		Person person=personDao.getPersonById(personId);
		Branch branch=branchDao.getBranchById(branchId);
		if(person!=null && branch!=null)
		{
		entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		encounter.setBranch(branch);
		encounter.setPerson(person);
		entityManager.persist(encounter);
		entityTransaction.commit();
		return true;
		}
		else
		{
			return false;
		}
		
}
	public Encounter getEncounterById(int id)
	{
		return entityManager.find(Encounter.class, id);
	}
	
	public List<Encounter> getAllEncounters()
	{
		Query query=entityManager.createQuery("Select e from Encounter e");
		return query.getResultList();
	}
	
	public List<Encounter> getEncountersByPersonId(int personId) {
		Query query=	entityManager.createQuery("select e from Encounter e where e.person.id=?1");
		query.setParameter(1, personId);
		return query.getResultList();
	}
	
}
