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

String account=request.getParameter("account");
String pwd=request.getParameter("pwd");

request.setAttribute("account", account);
request.getRequestDispatcher("test9.jsp").forward(request, response);



%>

</body>
</html>