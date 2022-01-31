package com.ty.hospital.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.hospital.dao.EncounterDao;
import com.ty.hospital.dao.OrderDao;
import com.ty.hospital.dto.Encounter;
import com.ty.hospital.dto.Orders;

@WebServlet(value="/createorder")
public class CreateOrderServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Orders order=new Orders();
		
		HttpSession httpSession=req.getSession();	
		//Integer branchId=(Integer)httpSession.getAttribute("branchid");
		String name=(String)httpSession.getAttribute("name");
		String message=	req.getParameter("orderMessage");
		
	    String date=req.getParameter("orderDate");
	   LocalDateTime localDateTime=LocalDateTime.parse(date,DateTimeFormatter.ISO_DATE_TIME);
			
		order.setMessage(message);
		order.setCreatorName(name);
		order.setCreatedDateTime(localDateTime);
		
		int encounterid=Integer.parseInt(req.getParameter("encounterid"));
		
		OrderDao orderDao=new OrderDao();
		orderDao.createOrder(encounterid, order);
		
		PrintWriter printWriter = resp.getWriter();
		printWriter.print("<html><body><h1> Order Created </h1></body></html>");

		RequestDispatcher dispatcher = req.getRequestDispatcher("CreateOrder.jsp");
		dispatcher.include(req, resp);
	}
}
