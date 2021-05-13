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

<%
User user=new User();

user.setId(1);
user.setName("bwf");
%>

<%=user.getId() %><br/>
<%=user.getName() %><br/>

<%

out.print("hello ");

%>

<%

String a=request.getParameter("a");
out.print(a);

//response.sendRedirect("test3.jsp");
out.print("<br/>");
out.print(request.getSession().getId());
out.print("<br/>");
out.print(session.getId());
response.getWriter().print("输出");
out.print("输出2<br/>");

out.print(config.getInitParameter("encoding"));
out.print("<br/>");

out.print(application.getInitParameter("a"));

pageContext.setAttribute("name", "bwf_page");
//pageContext.setAttribute("name", "bwf_page",PageContext.REQUEST_SCOPE);
request.setAttribute("name", "bwf_request");
session.setAttribute("name", "bwf_session");
application.setAttribute("name", "bwf_application");

out.print("<br/>");


out.print(pageContext.getAttribute("name"));
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

<jsp:forward page="test5.jsp"></jsp:forward>

</body>
</html>