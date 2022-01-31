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
import com.ty.hospital.dao.OrderDao;
import com.ty.hospital.dto.Encounter;
import com.ty.hospital.dto.Orders;

@WebServlet(value="/getorders")
public class GetOrdersServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		OrderDao orderDao=new OrderDao();
		List<Orders> orders=orderDao.getAllOrders();
		
		
		req.setAttribute("orderslist", orders);
		RequestDispatcher dispatcher=req.getRequestDispatcher("DisplayOrder.jsp");
		dispatcher.forward(req, resp);
		
	}
}
