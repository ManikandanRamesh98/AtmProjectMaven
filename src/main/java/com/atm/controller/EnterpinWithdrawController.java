package com.atm.controller;





import java.io.IOException;

import com.atm.impl.UserProfileImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Enterpinservlet")
public class EnterpinWithdrawController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String user = session.getAttribute("user").toString();
		int pin = Integer.parseInt(req.getParameter("withpin"));
		UserProfileImpl userprofileimpl = new UserProfileImpl();
		try {
			int userpin = userprofileimpl.getuserpin(user);
			if (userpin > 0) {
				if (userpin == pin) {
					res.sendRedirect("withdrawserv");
				} else {
					session.setAttribute("invalidpin", true);
					res.sendRedirect("Withdraw.jsp");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
