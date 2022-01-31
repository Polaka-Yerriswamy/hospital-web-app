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
import com.ty.hospital.dao.ItemDao;
import com.ty.hospital.dto.Branch;
import com.ty.hospital.dto.Items;

@WebServlet(value="/createitem")
public class CreateItemServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpSession=req.getSession();	
	

	
		String name=req.getParameter("itemName");
		String quantity=req.getParameter("itemQuantity");
		String price=req.getParameter("itemPrice");
		String message=req.getParameter("itemMessage");
		
		Items  item=new Items();
		item.setName(name);
		item.setQuantity(Integer.parseInt(quantity));
		item.setPrice(Double.parseDouble(price));
		item.setMessage(message);
		
		int orderId=Integer.parseInt(req.getParameter("orderid"));
		
		ItemDao itemDao=new ItemDao();
		itemDao.createItem(orderId, item);
		
		
		PrintWriter printWriter = resp.getWriter();
		printWriter.print("<html><body><h1> Item Created </h1></body></html>");

		RequestDispatcher dispatcher = req.getRequestDispatcher("CreateItem.jsp");
		dispatcher.include(req, resp);
	}
}
