<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String h="head.jsp";
String f="foot.jsp";
%>

<%@include file="head.jsp" %>
test2 page

 <jsp:include page="<%=f %>"></jsp:include>
 
 
</body>
</html>