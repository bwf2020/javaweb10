<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div style="text-align: center;">
欢迎来到博为峰
</div>


<div style="float: left;">
<ul>

<li><a href="index.jsp?p=a2.jsp">a页面</a></li>
<li><a href="index.jsp?p=b2.jsp">b页面</a></li>
<li><a href="index.jsp?p=c2.jsp">c页面</a></li>

</ul>

</div>

<div style="float: left;margin-left: 10px">


<jsp:include page='<%=request.getParameter("p")==null?"a2.jsp":request.getParameter("p") %>'></jsp:include>
	

</div>



</body>
</html>