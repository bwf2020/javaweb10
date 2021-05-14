<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<fmt:formatNumber value="1234567.12345"></fmt:formatNumber><br/>

<fmt:formatNumber value="1234567.12345" maxFractionDigits="2"></fmt:formatNumber><br/>


<fmt:formatNumber value="1234567.12345" pattern="0000000000000.000000000"></fmt:formatNumber><br/>
<fmt:formatNumber value="1234567.12345" pattern="￥##,###.##"></fmt:formatNumber><br/>



<fmt:formatDate value="<%=new Date() %>"/><br/>

<fmt:formatDate value="<%=new Date() %>" type="both"/><br/>

<fmt:formatDate value="<%=new Date() %>" pattern="yyyy年MM月dd日 HH:mm:ss"/><br/>


${fn:contains(param.name,"bwf") }<br/>

<%
String[] str={"a","asd","dfds","ad","asffs"};

pageContext.setAttribute("str", str);

%>

${fn:length(str) }<br/>




</body>
</html>