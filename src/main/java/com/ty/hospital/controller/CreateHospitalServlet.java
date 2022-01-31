package com.ty.hospital.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.hospital.dao.HospitalDao;
import com.ty.hospital.dto.Hospital;

@WebServlet("/createhospital")
public class CreateHospitalServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Hospital hospital=new Hospital();
		
		String name=req.getParameter("hospitalName");
		String website=req.getParameter("hospitalWebsite");
		String gst=req.getParameter("hospitalGst");
		
		hospital.setName(name);
		hospital.setWebsite(website);
		hospital.setGst(Double.parseDouble(gst));
		
		
		HospitalDao hospitalDao=new HospitalDao();
		 hospitalDao.createHospital(hospital);
		 
		 PrintWriter pw=resp.getWriter();
		 pw.print("<html><body><h1>Hospital is Created</h1></body></html>");
		 
		 RequestDispatcher dispatcher=req.getRequestDispatcher("CreateHospital.jsp");
		 dispatcher.forward(req, resp);
	}
}
