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

import com.ty.hospital.dao.UserDao;
import com.ty.hospital.dto.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		UserDao dao = new UserDao();
		User user = dao.validateUser(email, password);

		if (user != null) {

			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("name", user.getName());
			httpSession.setAttribute("role", user.getRole());

			if (user.getRole().equals("staff")) {
				httpSession.setAttribute("branchid", user.getBranch().getId());
				RequestDispatcher dispatcher = req.getRequestDispatcher("StaffHome.jsp");
				dispatcher.forward(req, resp);
			}
			if (user.getRole().equals("user")) {
				RequestDispatcher dispatcher = req.getRequestDispatcher("UserHome.jsp");
				dispatcher.forward(req, resp);
			}
			if (user.getRole().equals("admin")) {
				RequestDispatcher dispatcher = req.getRequestDispatcher("AdminHome.jsp");
				dispatcher.forward(req, resp);
			}

		} else {
			PrintWriter pout = resp.getWriter();
			pout.print("<h1>Invalid email or password</h1>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("Login.jsp");
			dispatcher.include(req, resp);

		}

	}
}
