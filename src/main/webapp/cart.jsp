<%@page import="java.util.List"%>
<%@page import="com.entity.Cart"%>
<%@page import="DB.DBConnect"%>
<%@page import="com.DAO.CartDAOImpl"%>
<%@page import="com.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart Page</title>
<%@include file="all_component/allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2">
	<%@include file="all_component/navbar.jsp"%>
	
	
	<c:if test="${empty userobj }">
	<c:redirect url="Login.jsp"></c:redirect>
	</c:if>
	
	<c:if test="${not empty succMsg }">
		<div class="alert alert-success" role="alert">${succMsg }</div>
			<c:remove var="succMsg" scope="session"/>
	</c:if>
	
	<c:if test="${not empty failedMsg }">
		<div class="alert alert-success text-center" role="alert">${failedMsg }</div>
			<c:remove var="failedMsg" scope="session"/>
	</c:if>
	

	<div class="container">
		<div class="row p-2">
			<div class="col-md-6">
				<div class="card bg-white">
					<div class="card-body">
						<h3 class="text-center text-success">Your selected Item</h3>
						<table class="table table-striped">
							<thead>
								<tr>
									<th scope="col">Book Name</th>
									<th scope="col">Author</th>
									<th scope="col">Price</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
							
							<%
							User u = (User)session.getAttribute("userobj");
							CartDAOImpl  dao = new CartDAOImpl(DBConnect.getconn());
							List<Cart> cart = dao.getBookByUser(u.getId());
							Double totalprice = 0.00;
							for(Cart c : cart)
							{
								totalprice = c.getTotal_price();
							%>
									<tr>
									<th scope="row"><%=c.getBook_name() %></th>
									<td><%=c.getAuthor() %></td>
									<td><%=c.getPrice() %></td>
									<td>
									<a href="remove_book?bid=<%=c.getBid() %>&&uid=<%=c.getUid() %>&&cid=<%=c.getCid() %>" class="btn btn-sm btn-danger">Remove</a>
									</td>
								</tr> 
							<%}
							%>
							
							<tr>
							<td>Total Price</td>
							<td></td>
							<td></td>
							<td><%=totalprice %></td>
							</tr>
					
							
							
								
							</tbody>
						</table>
					</div>
				</div>
			</div>


			<div class="col-md-6">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center text-success">Your Dtails For Order</h3>

						<form action="order" method="post">
						<input type="hidden" value="${userobj.id }" name="id">
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Name</label> <input type="text" name="username"
										class="form-control" id="inputEmail4" value="<%=u.getName()%>" readonly="readonly" required="required">
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Email</label> <input type="email" name="email"
										class="form-control" id="inputPassword4" value="<%=u.getEmail()%>"  readonly="readonly" required="required">
								</div>
							</div>

							<div class="form-row">
				 				<div class="form-group col-md-6">
									<label for="inputEmail4">Phone Number</label> <input
										type="number" name="phone" class="form-control" id="inputEmail4" value="<%=u.getPhone()%>"  readonly="readonly" required="required">
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Address</label> <input type="text" name="address"
										class="form-control" id="inputPassword4" required="required">
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">LandMark</label> <input type="text" name="landmark"
										class="form-control" id="inputEmail4" required="required">
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">City</label> <input type="text" name="city"
										class="form-control" id="inputPassword4" required="required">
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">State</label> <input type="text" name="state"
										class="form-control" id="inputEmail4" required="required">
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Zip</label> <input type="text" name="zip"
										class="form-control" id="inputPassword4" required="required">
								</div>
							</div>

							<div class="form-group">
								<label>Payment Model</label> <select class="form-control" name="paymentType">
									<option value="no_select">---select---</option>
									<option value="COD">Cash On Delivery</option>
								</select>
							</div>

							<div class="text-center">
								<button class="btn btn-warning">Order Now</button>
								<a href="index.jsp" class="btn btn-success">Continue
									Shopping</a>
							</div>


						</form>

					</div>
				</div>
			</div>



		</div>
	</div>

</body>
</html>