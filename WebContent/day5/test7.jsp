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
<jsp:setProperty property="id" name="user" value="100"/>
<jsp:setProperty property="name3" name="user" value="bwf"/>
<jsp:setProperty property="myTel" name="user" value="138222568978"/>
<jsp:setProperty property="mAddress" name="user" value="南京"/>

<%=user.getId() %><br/>
<%=user.getName3() %><br/>
<%=user.getMyTel() %><br/>
<%=user.getmAddress() %><br/>

<hr/>

<jsp:getProperty property="id" name="user"/><br/>
<jsp:getProperty property="name3" name="user"/><br/>
<jsp:getProperty property="myTel" name="user"/><br/>
<jsp:getProperty property="mAddress" name="user"/><br/>


<%

User user2=new User();
pageContext.setAttribute("user2", user2,PageContext.REQUEST_SCOPE);

user2.setName3("zhangsan");

%>

<%=user2.getName3() %>

<jsp:forward page="test8.jsp"></jsp:forward>

</body>
</html>