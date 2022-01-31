package com.ty.hospital.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.hospital.dao.AddressDao;
import com.ty.hospital.dao.BranchDao;
import com.ty.hospital.dao.EncounterDao;
import com.ty.hospital.dao.HospitalDao;
import com.ty.hospital.dto.Address;
import com.ty.hospital.dto.Branch;
import com.ty.hospital.dto.Encounter;
import com.ty.hospital.dto.Hospital;

@WebServlet(value="/getaddress")
public class GetAddressServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	    AddressDao addressDao=new AddressDao();
		List<Address> address=addressDao.getAllAddress();
		
		
		req.setAttribute("addresslist",address);
		RequestDispatcher dispatcher=req.getRequestDispatcher("DisplayAddress.jsp");
		dispatcher.forward(req, resp);
		
	}
}
