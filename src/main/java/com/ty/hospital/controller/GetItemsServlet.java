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
import com.ty.hospital.dao.ItemDao;
import com.ty.hospital.dto.Encounter;
import com.ty.hospital.dto.Hospital;
import com.ty.hospital.dto.Items;

@WebServlet(value="/getitems")
public class GetItemsServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		ItemDao itemDao=new ItemDao();
		List<Items> items=itemDao.getAllItems();
		
		
		req.setAttribute("itemslist", items);
		RequestDispatcher dispatcher=req.getRequestDispatcher("DisplayItem.jsp");
		dispatcher.forward(req, resp);
		
	}
}
