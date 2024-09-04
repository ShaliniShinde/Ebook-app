<%@page import="com.entity.book_order"%>
<%@page import="java.util.List"%>
<%@page import="DB.DBConnect"%>
<%@page import="com.DAO.BookOrderImpl"%>
<%@page import="com.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_component/allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2">

	<c:if test="${empty userobj }">
		<c:redirect url="Login.jsp"></c:redirect>
	</c:if>

	<%@include file="all_component/navbar.jsp"%>



	<div class="container p-1 ">
		<h3 class="text-center text-primary">Your Order</h3>
		<table class="table table-striped mt-3">
			<thead class="bg-primary text-white">
				<tr>
					<th scope="col">Order Id</th>
					<th scope="col">Name</th>
					<th scope="col">Book Name</th>
					<th scope="col">Author</th>
					<th scope="col">Price</th>
					<th scope="col">Payment type</th>
				</tr>
			</thead>
			<tbody>


				<%
				User u = (User) session.getAttribute("userobj");
				BookOrderImpl dao = new BookOrderImpl(DBConnect.getconn());
				List<book_order> blist = dao.getBook(u.getEmail());
				for (book_order b : blist) {
				%>
				<tr>
					<th scope="row"><%=b.getOrderId()%></th>
					<td><%=b.getUsename()%></td>
					<td><%=b.getBook_name()%></td>
					<td><%=b.getAuthor()%></td>
					<td><%=b.getPrice()%></td>
					<td><%=b.getPaymentType()%></td>
				</tr>
				<%
				}
				%>


			</tbody>
		</table>
	</div>

</body>
</html>