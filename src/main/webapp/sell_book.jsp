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
	<%@include file="all_component/navbar.jsp"%>

	<c:if test="${empty userobj  }">
		<c:redirect url="Login.jsp"></c:redirect>
	</c:if>


	<div class="container p-2">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="text-center text-primary p-1">Sell Old Book</h5>

						<c:if test="${not empty succMsg }">
							<p class="text-center text-success">${ succMsg}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<c:if test="${not empty failMsg }">
							<p class="text-center text-danger">${ failMsg}</p>
							<c:remove var="failMsg" scope="session" />
						</c:if>

						<form action="add_old_book" method="post"
							enctype="multipart/form-data">



							<input type="hidden" value="${userobj.email }" name="user">
							<div class="form-group">
								<label for="exampleInputEmail1">Book Name</label> <input
									name="bname" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp">
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Author Name</label> <input
									name="author" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp">
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Price</label> <input
									name="price" type="number" class="form-control"
									id="exampleInputEmail1">
							</div>


							<div class="form-group">
								<label for="exampleInputEmail1">Upload Photo</label> <input
									name="bimg" type="file" class="form-control-file"
									id="exampleInputEmail1">
							</div>

							<button type="submit" class="btn btn-primary">Sell</button>
						</form>


					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>