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

<c:out value="bwf"></c:out><br/>

<c:out value="<b>bwf</b>" escapeXml="false"></c:out><br/>

${"<b>bwf</b>" }<br/>

<c:out value="${param.name}" default="博为峰"></c:out>

<c:set var="a" value="AAAAAA" scope="session"></c:set><br/>

<c:out value="${a }"></c:out><br/>

<%=pageContext.getAttribute("a") %><br/>

<%=request.getAttribute("a") %><br/>

<%=session.getAttribute("a") %><br/>

${a }<br/>
<%
//session.removeAttribute("a");
%>

<c:remove var="a"/>
<%=session.getAttribute("a") %><br/>

<c:if test="${param.name=='bwf' }">

显示数据

</c:if>



<%
if(request.getParameter("name").equals("bwf")){
%>

显示数据

<%}else{ %>

显示其他

<%} %>


<c:choose>

<c:when test="${param.name=='bwf' }">显示博为峰</c:when>
<c:otherwise>显示其他</c:otherwise>

</c:choose>


<%-- <c:redirect url="test1.jsp"></c:redirect> --%>







</body>
</html>