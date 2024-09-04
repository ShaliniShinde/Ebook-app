package com.entity;

public class book_order {

	private int id;
	private String orderId;
	private String usename;
	private String email;
	private String address;
	private String phone;
	private String book_name;
	private String author;
	private String price;

	public book_order(int id, String orderId, String usename, String email, String address, String phone,
			String book_name, String author, String price, String paymentType) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.usename = usename;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.book_name = book_name;
		this.author = author;
		this.price = price;
		this.paymentType = paymentType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
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

	private String paymentType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUsename() {
		return usename;
	}

	public void setUsename(String usename) {
		this.usename = usename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public book_order() {
		super();
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public book_order(int id, String usename, String email, String phone, String fulladd, String paymentType) {
		super();
		this.id = id;
		this.usename = usename;
		this.email = email;
		this.phone = phone;

		this.paymentType = paymentType;
	}

	@Override
	public String toString() {
		return "book_order [id=" + id + ", orderId=" + orderId + ", usename=" + usename + ", email=" + email
				+ ", address=" + address + ", phone=" + phone + ", book_name=" + book_name + ", author=" + author
				+ ", price=" + price + ", paymentType=" + paymentType + "]";
	}

}
