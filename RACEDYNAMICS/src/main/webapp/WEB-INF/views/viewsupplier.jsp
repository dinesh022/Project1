<%@ page language="java" contentType="text/html" import="com.ecommerce.model.Supplier"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Here you can view the supplier details</title>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp" %>

<table class="table table-striped table-hover" style="width:100%">
	<tr bgcolor="gray">
		<td>Supplier ID</td>
		<td>Supplier Name</td>
		
		<td>Operation</td>
	</tr>
	
	<c:forEach items="${listsupplier}" var="supplier">
		<tr bgcolor="#F7DC6F  ">
			<td>${supplier.sid}</td>
			<td>${supplier.supplierName}</td>
			
			<td>
			
				<a class="btn btn-danger" href="#"/>DELETE</a>/
				<a class="btn btn-success" href="#"/>EDIT</a>
			</td>
		</tr>
	</c:forEach>

</table>
</body>
</html>