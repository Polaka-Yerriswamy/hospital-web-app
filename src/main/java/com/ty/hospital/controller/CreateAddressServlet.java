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

import com.ty.hospital.dao.AddressDao;
import com.ty.hospital.dao.BranchDao;
import com.ty.hospital.dto.Address;
import com.ty.hospital.dto.Branch;
import com.ty.hospital.dto.Items;

@WebServlet(value="/createaddress")
public class CreateAddressServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpSession=req.getSession();	
		

	
		String address=req.getParameter("Address");
		String state=req.getParameter("State");
		String pin=req.getParameter("Pin");
		
		Address address2=new Address();
		address2.setAdress(address);
		address2.setState(state);
		address2.setPin(Integer.parseInt(pin));
		
		int BranchId=Integer.parseInt(req.getParameter("branchid"));
		
		AddressDao addressDao=new AddressDao();
		addressDao.createAddress(BranchId, address2);
		
		PrintWriter printWriter = resp.getWriter();
		printWriter.print("<html><body><h1> Address Created </h1></body></html>");

		RequestDispatcher dispatcher = req.getRequestDispatcher("CreateAddress.jsp");
		dispatcher.include(req, resp);
	}
}
