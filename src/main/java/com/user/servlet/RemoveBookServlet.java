package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.CartDAOImpl;

import DB.DBConnect;

@WebServlet("/remove_book")
public class RemoveBookServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			int bid =Integer.parseInt(req.getParameter("bid"));
			int uid =Integer.parseInt(req.getParameter("uid"));
			int cid =Integer.parseInt(req.getParameter("cid"));
			CartDAOImpl dao = new CartDAOImpl(DBConnect.getconn());
			boolean f = dao.deletebook(bid,uid,cid);
			HttpSession session = req.getSession();

			if (f) {
				session.setAttribute("succMsg", "Book remove from cart");
				resp.sendRedirect("cart.jsp");
			} else {
				session.setAttribute("failedMsg", "Something wrong on server..");
				resp.sendRedirect("cart.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
