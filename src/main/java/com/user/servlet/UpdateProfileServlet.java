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

@WebServlet("/update_profile")
public class UpdateProfileServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			String password = req.getParameter("password");
			
			User us = new User();
			us.setId(id);
			us.setName(name);
			us.setEmail(email);
			us.setPhone(phone);
			
			HttpSession session = req.getSession();
			
			UserDAOImpl dao = new UserDAOImpl(DBConnect.getconn());
			boolean f = dao.checkPassword(id, password);
			if(f)
			{
				Boolean f2 = dao.updateProfile(us);
				if(f2)
				{
					session.setAttribute("succMsg", "Profile update successfully...");
					resp.sendRedirect("edit_profile.jsp");
				}
				else
				{
					session.setAttribute("failedMsg", " Something wrong on server...");
					resp.sendRedirect("edit_profile.jsp");
				}
			}
			else
			{
				session.setAttribute("failedMsg", " Your password is incorrect...");
				resp.sendRedirect("edit_profile.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

}
