package com.ty.hospital.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.hospital.dao.EncounterDao;
import com.ty.hospital.dao.HospitalDao;
import com.ty.hospital.dto.Encounter;
import com.ty.hospital.dto.Hospital;

@WebServlet(value="/gethospitals")
public class GetHospitalsServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HospitalDao hospitalDao=new HospitalDao();
		List<Hospital> hospitals=hospitalDao.getAllHospitals();
		
		
		req.setAttribute("hospitalslist", hospitals);
		RequestDispatcher dispatcher=req.getRequestDispatcher("DisplayHospital.jsp");
		dispatcher.forward(req, resp);
		
	}
}
