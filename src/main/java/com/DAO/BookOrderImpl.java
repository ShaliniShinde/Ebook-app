package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.book_order;

public class BookOrderImpl implements BookOrderDAO {

	private Connection con;

	public BookOrderImpl(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public boolean saveOrder(List<book_order> blist) {
		boolean f = false;
		try {
			String sql = "insert into book_order(order_id, user_name, email, address, phone, book_name, author, price, payment) values(?,?,?,?,?,?,?,?,?)";
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(sql);
			for (book_order b : blist) {
				ps.setString(1, b.getOrderId());
				ps.setString(2, b.getUsename());
				ps.setString(3, b.getEmail());
				ps.setString(4, b.getAddress());
				ps.setString(5, b.getPhone());
				ps.setString(6, b.getBook_name());
				ps.setString(7, b.getAuthor());
				ps.setString(8, b.getPrice());
				ps.setString(9, b.getPaymentType());
				ps.addBatch();
			}

			int[] count = ps.executeBatch();
			con.commit();
			f = true;
			con.setAutoCommit(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public List<book_order> getBook(String email) {
		List<book_order> list = new ArrayList<book_order>();
		book_order o = null;
		try {
			String sql = "select * from book_order where email=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				o = new book_order();
				o.setId(rs.getInt(1));
				o.setOrderId(rs.getString(2));
				o.setUsename(rs.getString(3));
				o.setEmail(rs.getString(4));
				o.setAddress(rs.getString(5));
				o.setPhone(rs.getString(6));
				o.setBook_name(rs.getString(7));
				o.setAuthor(rs.getString(8));
				o.setPrice(rs.getString(9));
				o.setPaymentType(rs.getString(10));
				list.add(o);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<book_order> getAllOrder() {
		List<book_order> list = new ArrayList<book_order>();
		book_order o = null;
		try {
			String sql = "select * from book_order";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				o = new book_order();
				o.setId(rs.getInt(1));
				o.setOrderId(rs.getString(2));
				o.setUsename(rs.getString(3));
				o.setEmail(rs.getString(4));
				o.setAddress(rs.getString(5));
				o.setPhone(rs.getString(6));
				o.setBook_name(rs.getString(7));
				o.setAuthor(rs.getString(8));
				o.setPrice(rs.getString(9));
				o.setPaymentType(rs.getString(10));
				list.add(o);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
