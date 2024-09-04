package com.user.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.BookOrderImpl;
import com.DAO.CartDAOImpl;
import com.entity.BookDtls;
import com.entity.Cart;
import com.entity.book_order;

import DB.DBConnect;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			HttpSession session = req.getSession();
			
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("username");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			String address = req.getParameter("address");
			String landmark = req.getParameter("landmark");
			String city = req.getParameter("city");
			String state = req.getParameter("state");
			String pincode = req.getParameter("zip");
			String paymentType = req.getParameter("paymentType");
			
			String fullAddress = address + "," + landmark + "," + city + "," + state + ","  + pincode;
			
			System.out.println(name + " " + email + " " + phone + " " + fullAddress + " " + paymentType );
			
			CartDAOImpl dao = new CartDAOImpl(DBConnect.getconn());
			List<Cart>	b =	dao.getBookByUser(id);
			
			if(b.isEmpty())
			{
				session.setAttribute("failedMsg", "Add Item");
				resp.sendRedirect("cart.jsp");
			}
			else
			{
				BookOrderImpl dao2 = new BookOrderImpl(DBConnect.getconn());
				
				
				book_order o = null;
				
				ArrayList<book_order> orderlist = new ArrayList<book_order>();
				Random rs = new Random();
				for(Cart c: b)
				{
					o=new book_order();
					o.setOrderId("Book-ORD-00"+rs.nextInt(1000));
					o.setUsename(name);
					o.setEmail(email);
					o.setPhone(phone);
					o.setAddress(fullAddress);
					o.setBook_name(c.getBook_name());
					o.setAuthor(c.getAuthor());
					o.setPrice(c.getPrice() + "");
					o.setPaymentType(paymentType);
					orderlist.add(o);
					
				}
				
				
				if("no_select".equals(paymentType))
				{
					
					session.setAttribute("failedMsg", "please chose your payment type");
					resp.sendRedirect("cart.jsp");
				}
				else {
					boolean f = dao2.saveOrder(orderlist);
					
					if(f)
					{
						resp.sendRedirect("Order_success_page.jsp");
						
					}
					else
					{
						session.setAttribute("failedMsg", "your order failed");
						resp.sendRedirect("cart.jsp");
					}
				}
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
		

}
