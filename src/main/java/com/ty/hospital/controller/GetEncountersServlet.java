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
import com.ty.hospital.dao.PersonDao;
import com.ty.hospital.dto.Encounter;
import com.ty.hospital.dto.Person;
import com.ty.hospital.dto.User;

@WebServlet(value="/getencounters")
public class GetEncountersServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String personId=req.getParameter("personid");
		int parseId=Integer.parseInt(personId);
		
		EncounterDao encounterDao=new EncounterDao();
		List<Encounter> encounters=encounterDao.getEncountersByPersonId(parseId);
		
		
		req.setAttribute("encounterslist", encounters);
		RequestDispatcher dispatcher=req.getRequestDispatcher("DisplayEncounter.jsp");
		dispatcher.forward(req, resp);
		
			
	
	}
	
	
	
}
