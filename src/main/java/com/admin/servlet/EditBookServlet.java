package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.BookDAO;
import com.DAO.BookDAOImpl;
import com.entity.BookDtls;

import DB.DBConnect;

@WebServlet("/edit_bookss")
public class EditBookServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			int id = Integer.parseInt(req.getParameter("sid"));
			String bookName = req.getParameter("bname");
			String author = req.getParameter("author");
			String price = req.getParameter("price");
			String status = req.getParameter("bStatus");
			
			BookDtls b = new BookDtls();
			b.setBookId(id);
			b.setBookNmae(bookName);
			b.setAuthor(author);
			b.setPrice(price);
			b.setStatus(status);
			
			BookDAOImpl dao = new BookDAOImpl(DBConnect.getconn());
			boolean f = dao.updateEditBooks(b);
			
			HttpSession session = req.getSession();
			
			
			if(f)
			{
				session.setAttribute("succMsg", "Book update successfully");
				resp.sendRedirect("admin/all_books.jsps");
			}
			else
			{
				session.setAttribute("failMsg", "Something wrong on server");
				resp.sendRedirect("admin/all_books.jsps");
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

}
