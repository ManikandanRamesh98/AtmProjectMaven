package com.atm.controller;

import com.atm.impl.DepositImpl;
import com.atm.impl.UserProfileImpl;
import com.atm.models.DepositModel;

import com.atm.models.UserProfileModel;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/depserv")
public class DepositController extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) {
		UserProfileImpl userprofileimpl = new UserProfileImpl();
		DepositImpl depositimpl = new DepositImpl();
		HttpSession session = req.getSession();
		String uname = session.getAttribute("user").toString();
		int eamount = (int) session.getAttribute("depamount");
		try {
			UserProfileModel userprofilemodel = new UserProfileModel(uname);
			// get user balance:
			if (userprofileimpl.getbal(userprofilemodel) > 0) {
				int bal = userprofileimpl.getbal(userprofilemodel);
				// Amount greater than 0 and less than 30000:
				if (eamount > 0 && eamount < 30000) {
					int newbal = bal + eamount;
					UserProfileModel userprofilemodel2 = new UserProfileModel(uname, newbal);
					// update New Balance:
					int updatebal = userprofileimpl.insbal(userprofilemodel2);
					if (updatebal > 0) {
						// Get User Account Number:
						UserProfileModel userprofilemodel3 = new UserProfileModel(uname);
						Long acc = userprofileimpl.getaccno(userprofilemodel3);
						if (acc > 0) {
							// Insert in Deposit table:
							DepositModel depositmodel = new DepositModel(acc, eamount);
							depositimpl.insdep(depositmodel);
							session.setAttribute("depsuccamount", eamount);
							session.setAttribute("depsuccbal", newbal);
							res.sendRedirect("Depsucc.jsp");
						} else {
							res.getWriter().println("Cant Get User Account No!!");
						}
					} else {
						res.getWriter().println("Something Went Wrong!!");
					}
				} else {
					res.getWriter().println("Enter The Valid Amount!!");
				}
			} else {
				res.sendRedirect("Invaliduser.jsp");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
