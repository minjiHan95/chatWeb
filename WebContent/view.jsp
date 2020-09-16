<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<title>JSP</title>
</head>
<body>
	<!-- 내비게이션 바 -->
	<%
		if (session.getAttribute("memberID") == null) {
			PrintWriter ps = response.getWriter();
			ps.println("<script>");
			ps.println("alert('로그인 후 이용해주세요.')");
			ps.println("location.href = 'login.jsp';");
			ps.println("</script>");
	%>

	<%
		} else {
	%>
	<jsp:include page="headerB.jsp"></jsp:include>
	<%
		}
	%>
	<div class="container">
		<div class="row">
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="3"
							style="background-color: #eeeeee; text-align: center;">게시판 글
							보기</th>
					</tr>
				</thead>
				<tbody>
					<!-- 글 내용 -->
				</tbody>
			</table>
			<a href="view.jsp" class="btn btn-primary">목록</a> <a
				href="update.jsp?bbsID=" class="btn btn-primary">수정</a> <a
				onclick="return confirm('정말로 삭제하시겠습니까?')"
				href="deleteAction.jsp?boardID=" class="btn btn-primary">삭제</a>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>