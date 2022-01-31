package com.ty.hospital.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.hospital.dao.PersonDao;
import com.ty.hospital.dto.Person;
import com.ty.hospital.dto.User;

@WebServlet(value="/getpersons")
public class GetPersonsServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PersonDao persons=new PersonDao();
		List<Person> person=persons.getAllPersons();
		
		
		req.setAttribute("personslist", person);
		RequestDispatcher dispatcher=req.getRequestDispatcher("DisplayPerson.jsp");
		dispatcher.forward(req, resp);
		
			
	
	}
	
	
	
}
