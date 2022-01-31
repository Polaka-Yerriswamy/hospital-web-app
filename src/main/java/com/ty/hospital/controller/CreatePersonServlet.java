package com.ty.hospital.controller;

	import java.io.IOException;
	import java.io.PrintWriter;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

import com.ty.hospital.dao.PersonDao;
import com.ty.hospital.dto.Person;

	public class CreatePersonServlet extends HttpServlet {
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			Person person= new Person();

			String name = req.getParameter("personName");
			String email = req.getParameter("personEmail");
			
			String gender = req.getParameter("personGender");
			String phone = req.getParameter("personPhone");
			String age = req.getParameter("personAge");

			person.setName(name);
			person.setEmail(email);
			person.setGender(gender);
			person.setPhone(Long.parseLong(phone));
			person.setAge(Integer.parseInt(age));

			PersonDao personDao  = new PersonDao();
			personDao.createPerson(person);

			PrintWriter printWriter = resp.getWriter();
			printWriter.print("<html><body><h1> Person Created </h1></body></html>");

			RequestDispatcher dispatcher = req.getRequestDispatcher("CreatePerson.jsp");
			dispatcher.include(req, resp);
		}

	}

