package com.DAO;

import java.util.List;

import com.entity.BookDtls;

public interface BookDAO {

	public boolean addBook(BookDtls b);

	public List<BookDtls> getAllBooks();
	
	public BookDtls getBookById(int id);
	
	public boolean updateEditBooks(BookDtls bs);
	
	public List<BookDtls> getNewBook();
	
	public List<BookDtls> getRecentBook();
	
	public List<BookDtls> getOldBook();
	
	public List<BookDtls> getAllRecentBook();
	
	public List<BookDtls> getAllNewBook();
	
	public List<BookDtls> getAllOldBook();
	
	public List<BookDtls> getBookByOld(String email, String cate);
	
	public boolean oldBookDelete(String email, String cate,int id);
	
	public List<BookDtls> getBookBySearch(String ch);
	
	

}
