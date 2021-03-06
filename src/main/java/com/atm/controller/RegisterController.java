package com.atm.controller;

import java.io.IOException;
import java.sql.ResultSet;
import com.atm.impl.UserProfileImpl;
import com.atm.impl.UsernamePasswordImpl;
import com.atm.models.UsernamePasswordModel;
import com.atm.models.UserProfileModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/registersucc")
public class RegisterController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UsernamePasswordImpl userimpl = new UsernamePasswordImpl();
		UserProfileImpl userprofileimpl = new UserProfileImpl();
		Long accno = 0l;
		int userpin = 0;
		try {
			accno = userprofileimpl.getusermaxacc()+1;
			userpin = userprofileimpl.getusermaxpin()+1;
//			System.out.println(accno);
//			ResultSet rSet1 = userprofileimpl.getusermaxpin();
//			while (rSet.next()) {
//				accno = rSet.getLong(1) + 1;
//			}
//			while (rSet1.next()) {
//				userpin = rSet1.getInt(1) + 1;
//			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String username = req.getParameter("userreg");
		String password = req.getParameter("passreg");
		String role = req.getParameter("rolereg");
		Long mobno = Long.parseLong(req.getParameter("mobnoreg"));
		try {
			UsernamePasswordModel usernamepassmodel = new UsernamePasswordModel(username, password, role);
			int ins = userimpl.insusernamepass(usernamepassmodel);
			if (ins > 0) {
				if (role.equals("admin")) {
					HttpSession session = req.getSession();
					session.setAttribute("adminreg", username);
					resp.sendRedirect("Adminregsucc.jsp");
				} else if (role.equals("admin")) {
					HttpSession session = req.getSession();
					session.setAttribute("agentreg", username);
					resp.sendRedirect("Agentregsucc.jsp");
				} else {
					UserProfileModel userprofilemodel = new UserProfileModel(username, accno, mobno, userpin);
					int profins = userprofileimpl.insuserprofile(userprofilemodel);
					if (profins > 0) {
						HttpSession session = req.getSession();
						session.setAttribute("reguser", username);
						resp.sendRedirect("Registeruserprofilesucc.jsp");
					}
				}

			} else {
				resp.getWriter().println("something went wrong!! try again..");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
