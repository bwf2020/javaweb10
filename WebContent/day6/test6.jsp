<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="day5.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:forEach begin="1" end="10">

循环

</c:forEach>

<c:forEach begin="1" end="10" var="num" step="2">

	<%=pageContext.getAttribute("num") %>

</c:forEach>

<br/>

<%

String[] str={"zhangsan","lisi","wangwu","zhaoliu"};
pageContext.setAttribute("str", str);

List<User> users=new ArrayList<User>();
User u1=new User();
u1.setName3("张三");

User u2=new User();
u2.setName3("李四");

User u3=new User();
u3.setName3("王五");


users.add(u1);
users.add(u2);
users.add(u3);

pageContext.setAttribute("users", users);


Map map=new HashMap();

map.put("a", "AAAAA");
map.put("b", "BBBB");
map.put("c", "CCC");

pageContext.setAttribute("map", map);



%>


<ul>

	<c:forEach items="${str }" var="s">
	
	   <li>${s }</li>
	
	</c:forEach>

</ul>

<br/>

<ol>


<c:forEach items="${users }" var="user">

	<li>${user.name3 }</li>

</c:forEach>

</ol>


<c:forEach items="${map }" var="m">


	${m.key } ========= ${m.value }<br/>

</c:forEach>



<ol>


<c:forEach items="${users }" var="user" varStatus="s">

	<c:if test="${s.index%2!=0 }">
	
	<li style="color:red">
	
	</c:if>
	
	<c:if test="${s.index%2==0 }">
	
	<li>
	
	</c:if>
	
	
	${user.name3 } ${s.index } ${s.count } ${s.first } ${s.last }</li>

</c:forEach>

</ol>


<c:forTokens items="a,b,cd,efg,hi" delims="," var="str">

${str }

</c:forTokens>

<c:import url="http://www.baidu.com" charEncoding="utf-8"></c:import>





</body>
</html>