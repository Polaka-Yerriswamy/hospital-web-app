package com.ty.hospital.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.hospital.dao.BranchDao;
import com.ty.hospital.dao.EncounterDao;
import com.ty.hospital.dao.HospitalDao;
import com.ty.hospital.dto.Branch;
import com.ty.hospital.dto.Encounter;
import com.ty.hospital.dto.Hospital;

@WebServlet(value="/getbranchs")
public class GetBranchsServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	    BranchDao branchDao=new BranchDao();
		List<Branch> branchs=branchDao.getAllBranches();
		
		
		req.setAttribute("branchslist",branchs);
		RequestDispatcher dispatcher=req.getRequestDispatcher("DisplayBranch.jsp");
		dispatcher.forward(req, resp);
		
	}
}
