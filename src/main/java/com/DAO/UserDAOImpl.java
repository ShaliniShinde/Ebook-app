package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;

public class UserDAOImpl implements UserDAO{
	
	private Connection con;

	public UserDAOImpl(Connection con) {
		super();
		this.con = con;
	}

	public boolean userRegister(User us) {
		boolean f = false;
		try {
			String sql = "INSERT INTO user(name, email, phone, password) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,us.getName());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getPhone());
			ps.setString(4, us.getPassword());
			
			int i = ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public User login(String email, String password) {
		User us = null;
		
		try {
			String sql = "select * from user where email=? and password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
		ResultSet rs =	ps.executeQuery();
		
		while(rs.next())
		{
			us = new User();
			us.setId(rs.getInt(1));
			us.setName(rs.getNString(2));
			us.setEmail(rs.getNString(3));
			us.setPhone(rs.getString(4));
			us.setPassword(rs.getString(5));
			us.setAddress(rs.getString(6));
			us.setLandmark(rs.getString(7));
			us.setCity(rs.getString(8));
			us.setState(rs.getString(9));
			us.setZip(rs.getString(10));
			
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return us;
		
		
	}

	@Override
	public boolean checkPassword(int id, String ps) {
		boolean f = false;
		try {
			String sql = "select * from user where id=? and password=?";
			PreparedStatement ps1 = con.prepareStatement(sql);
			ps1.setInt(1, id);
			ps1.setString(2, ps);
			
			
			ResultSet rs = ps1.executeQuery();
			
			while(rs.next())
			{
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public boolean updateProfile(User us) {
		
		boolean f = false;
		try {
			String sql = "update user set name=?, email=?, phone=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,us.getName());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getPhone());
			ps.setInt(4, us.getId());
			
			int i = ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public boolean checkUser(String em) {
		boolean f = true;
		try {
			String sql = "select * from user where email=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,em);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				f=false;
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	

}
