package com.atm.controller;

import java.io.IOException;

import com.atm.impl.UserProfileImpl;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Enterpindepservlet")
public class EnterPinDepositController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String user = session.getAttribute("user").toString();
		int pin = Integer.parseInt(req.getParameter("deppin"));
		UserProfileImpl userprofileimpl = new UserProfileImpl();
		try {
			int userpin = userprofileimpl.getuserpin(user);
			if (userpin > 0) {
				if (userpin == pin) {
					res.sendRedirect("depserv");
				} else {
					session.setAttribute("invaliddeppin", true);
					res.sendRedirect("Deposit.jsp");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
