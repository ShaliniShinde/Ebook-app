package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAOImpl;
import com.entity.User;

import DB.DBConnect;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			String password = req.getParameter("password");
			String checkBox = req.getParameter("check");

			System.out.println(name + " " + email + " " + phone + " " + password + " " + checkBox);

			User us = new User();
			us.setName(name);
			us.setEmail(email);
			us.setPhone(phone);
			us.setPassword(password);
			
			HttpSession session = req.getSession();

			if (checkBox != null) {
				UserDAOImpl dao = new UserDAOImpl(DBConnect.getconn());
				
				boolean f2 = dao.checkUser(email);
				if(f2)
				{
					boolean f = dao.userRegister(us);

					if (f) {
						//System.out.println("User Regidster Sucess....");
						session.setAttribute("succMsg", " Regidster Sucess....");
						resp.sendRedirect("register.jsp");
					} else {
						//System.out.println("Something wrong on server...");
						session.setAttribute("failedMsg", " Something wrong on server...");
						resp.sendRedirect("register.jsp");
					}
				}
				else
				{
					session.setAttribute("failedMsg", " User already exist try another email..");
					resp.sendRedirect("register.jsp");
				}
				
				
				
				
				
			} else {
				//System.out.println("please check terms and condition");
				session.setAttribute("failedMsg", "please check terms and condition");
				resp.sendRedirect("register.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// super.doPost(req, resp);
	}

}
