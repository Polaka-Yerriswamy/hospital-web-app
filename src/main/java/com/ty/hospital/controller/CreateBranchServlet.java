package com.ty.hospital.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.hospital.dao.BranchDao;
import com.ty.hospital.dto.Branch;

@WebServlet(value="/createbranch")
public class CreateBranchServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpSession=req.getSession();	
		

	
		String name=req.getParameter("branchName");
		String email=req.getParameter("branchEmail");
		String phone=req.getParameter("branchPhone");
		
		Branch branch=new Branch();
		branch.setName(name);
		branch.setEmail(email);
		branch.setPhone(Long.parseLong(phone));
		
		int hospitalId=Integer.parseInt(req.getParameter("hospitalid"));
		
		BranchDao  branchDao=new BranchDao();
		branchDao.createBranch(hospitalId, branch);
		
		PrintWriter printWriter = resp.getWriter();
		printWriter.print("<html><body><h1> Branch Created </h1></body></html>");

		RequestDispatcher dispatcher = req.getRequestDispatcher("CreateBranch.jsp");
		dispatcher.include(req, resp);
	}
}
