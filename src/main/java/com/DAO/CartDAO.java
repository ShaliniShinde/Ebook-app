package com.DAO;

import java.util.List;

import com.entity.BookDtls;
import com.entity.Cart;

public interface CartDAO {
	
	public boolean addCart(Cart c);
	
	public List<Cart> getBookByUser(int userID);
	
	public boolean deletebook(int bid, int uid, int cid);

}
