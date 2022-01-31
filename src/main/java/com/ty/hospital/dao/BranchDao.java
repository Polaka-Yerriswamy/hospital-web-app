package com.ty.hospital.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dto.Branch;
import com.ty.hospital.dto.Hospital;
import com.ty.hospital.dto.Person;


public class BranchDao {


	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction;
	HospitalDao dao =new HospitalDao();
	
	public boolean createBranch(int hospitalId,Branch branch)
	{
		Hospital hospital=dao.getHospitalById(hospitalId);
		if(hospital!=null)
		{
		entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		branch.setHospital(hospital);
		entityManager.persist(branch);
		entityTransaction.commit();
		return true;
		}
		else
		{
			return false;
		}
}
	
	
	public List<Branch> getAllBranches()
	{
		Query query=entityManager.createQuery("Select h from Branch h");
		return query.getResultList();
	}
	
	
	public boolean deleteBranch(int id) {
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
	

	public Branch getBranchById(int branchId)
	{
		return entityManager.find(Branch.class, branchId);
	}
	
	
	
	public void updateBranch(Branch branch)
	{
		entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		entityManager.merge(branch);

		entityTransaction.commit();
}
}