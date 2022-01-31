package com.ty.hospital.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private long phone;
	private String email;
	
	@ManyToOne
	private Hospital hospital;
	@OneToOne
	private Address adress;
	@OneToMany
	private List<Encounter> encounters;
	@OneToMany
	private List<User> users;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAdress() {
		return adress;
	}

	public void setAdress(Address adress) {
		this.adress = adress;
	}

	public List<Encounter> getEncounters() {
		return encounters;
	}

	public void setEncounters(List<Encounter> encounters) {
		this.encounters = encounters;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	
	
}