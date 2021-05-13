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

out.print(pageContext.getAttribute("name"));
out.print("<br/>");
//out.print(pageContext.getAttribute("name",PageContext.REQUEST_SCOPE));
out.print("<br/>");
out.print(request.getAttribute("name"));
out.print("<br/>");
out.print(session.getAttribute("name"));
out.print("<br/>");
out.print(application.getAttribute("name"));

%>

<%
out.print("<br/>");
out.print(pageContext.findAttribute("name"));
%>

</body>
</html>