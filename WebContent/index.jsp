
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<title>CHAT WEB</title>
</head>

<body>

	<%
		if (session.getAttribute("memberID") == null) {
	%>
	<jsp:include page="headerA.jsp"></jsp:include>
	<%
		} else {
	%>
	<jsp:include page="headerB.jsp"></jsp:include>
	<%
		}
	%>

	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>