<%@page import="day5.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<jsp:useBean id="user" class="day5.User" scope="request"></jsp:useBean>

<jsp:getProperty property="name3" name="user"/>

<%=((User)request.getAttribute("user")).getName3()%>



<jsp:useBean id="user2" class="day5.User" scope="request"></jsp:useBean>
<jsp:getProperty property="name3" name="user2"/>

</body>
</html>