package com.admin.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.DAO.BookDAOImpl;
import com.entity.BookDtls;

import DB.DBConnect;

@WebServlet("/add_books")
@MultipartConfig
public class BooksAdd extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String bookName = req.getParameter("bname");
			String author = req.getParameter("author");
			String price = req.getParameter("price");
			String categories = req.getParameter("btype");
			String status = req.getParameter("bStatus");
			Part part = req.getPart("bimg");
			String fileName = part.getSubmittedFileName();

			BookDtls b = new BookDtls(0, bookName, author, price, categories, status, fileName, "admin");
			System.out.println(b);

			BookDAOImpl dao = new BookDAOImpl(DBConnect.getconn());

			boolean f = dao.addBook(b);

			HttpSession session = req.getSession();

			
			
			

			if (f) {
				
				String path = getServletContext().getRealPath("") + "book";
				System.out.println(path);
				
				// Ensure that the path ends with a file separator
				if (!path.endsWith(File.separator)) {
				    path += File.separator;
				}
				
				File file = new File(path);
				part.write(path+fileName);

				session.setAttribute("succMsg", "Book Add Succesfully");
				resp.sendRedirect("admin/add_books.jsp");
				
				
			} else {
				session.setAttribute("failMsg", "something wrong on server");
				resp.sendRedirect("admin/add_books.jsp");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
