<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="day5.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="user" class="day5.User"></jsp:useBean>
<jsp:setProperty property="name3" name="user" value="张三"/>


标准动作:<jsp:getProperty property="name3" name="user"/><br/>
脚本:<%=user.getName3() %><br/>
EL表达式:${ user.name3 }<br/>

<%

	User user2=new User();
	user2.setName3("李四");
	pageContext.setAttribute("user3", user2);
	
	User user3=new User();
	user3.setName3("王五");
	
	
	User user4=new User();
	user4.setName3("赵六");
	
	List<User> users=new ArrayList<User>();
	users.add(user2);
	users.add(user3);
	users.add(user4);
	
	pageContext.setAttribute("users", users);
	

%>
脚本:<%=user2.getName3() %><br/>
EL表达式:${ user3.name3 }<br/>


获取:${users[0].name3} <br/>
获取:${users[1].name3} <br/>
获取:${users[2].name3} <br/>


获取:${users[0]["name3"]} <br/>

${user.name3 }<br/>
${user["name3"] }<br/>

<%=((User)pageContext.getAttribute("user")).getName3() %><br/>

<%
String a="bwf_page";
String b="bwf_req";
String c="bwf_session";

pageContext.setAttribute("a", a);
request.setAttribute("a", b);
session.setAttribute("a", c);

%>

<%=pageContext.findAttribute("a") %><br/>

${a }<br/>



</body>
</html>