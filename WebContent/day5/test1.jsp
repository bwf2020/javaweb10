<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
 
<%@page import="java.util.Date"%>  
<%@page import="java.text.SimpleDateFormat"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@include file="head.jsp" %>

<%!

int a=0;

%>

<%
int b=0;
%>

a的值:<%=a++ %><br/>
b的值:<%=b++ %><br/>

<%!

public String show1(String name){
	
	
	
	return name.toUpperCase();
	
}

%>

<%=show1("bwf") %><br/>


<%=new Date() %>

<%=new SimpleDateFormat() %>

<!-- 跳转到test3页面  -->

<%=request %>

<%

//request.getRequestDispatcher("test3.jsp").forward(request, response);
%>

<%-- 
<jsp:forward page="test3.jsp"></jsp:forward>
 --%>
 
 <jsp:include page="foot.jsp"></jsp:include>

</body>
</html>