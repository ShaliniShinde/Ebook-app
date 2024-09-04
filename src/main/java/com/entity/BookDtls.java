package com.entity;

public class BookDtls {
	private int bookId;
	private String bookNmae;
	private String author;
	private String price;
	private String bookCategory;
	private String status;
	private String photoNmae;
	private String email;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookNmae() {
		return bookNmae;
	}

	public void setBookNmae(String bookNmae) {
		this.bookNmae = bookNmae;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhotoNmae() {
		return photoNmae;
	}

	public void setPhotoNmae(String photoNmae) {
		this.photoNmae = photoNmae;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BookDtls(int bookId, String bookNmae, String author, String price, String bookCategory, String status,
			String photoNmae, String email) {
		super();
		this.bookId = bookId;
		this.bookNmae = bookNmae;
		this.author = author;
		this.price = price;
		this.bookCategory = bookCategory;
		this.status = status;
		this.photoNmae = photoNmae;
		this.email = email;
	}

	public BookDtls() {
		super();
	}

	@Override
	public String toString() {
		return "BookDtls [bookId=" + bookId + ", bookNmae=" + bookNmae + ", author=" + author + ", price=" + price
				+ ", bookCategory=" + bookCategory + ", status=" + status + ", photoNmae=" + photoNmae + ", email="
				+ email + "]";
	}

}
