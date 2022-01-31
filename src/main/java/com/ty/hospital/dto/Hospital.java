package com.ty.hospital.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String website;
	private double gst;
	
	@OneToMany
	private List<Branch> branchs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public double getGst() {
		return gst;
	}

	public void setGst(double gst) {
		this.gst = gst;
	}

	public List<Branch> getBranchs() {
		return branchs;
	}

	public void setBranchs(List<Branch> branchs) {
		this.branchs = branchs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}