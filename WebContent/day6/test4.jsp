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
pageContext.setAttribute("name", "a");
request.setAttribute("name", "b");
session.setAttribute("name", "c");
application.setAttribute("name", "d");
%>

<%=request %><br/>
${requestScope }<br/>

<%=session %><br/>
${sessionScope }<br/>


<%=pageContext %><br/>
${pageContext }<br/>


${name }<br/>
${requestScope.name }<br/>

参数:<%=request.getParameter("name") %><br/>
参数2:${param.name }<br/>

参数3:${paramValues.aihao[0] }<br/>
参数3:${paramValues.aihao[1] }<br/>

头信息:<%=request.getHeader("Host") %><br/>
头信息:<%=request.getHeader("User-Agent") %><br/>

el：${header.Host }<br/>
el：${header["User-Agent"] }<br/>

<%
Cookie c1=new Cookie("a","AAAAA");
response.addCookie(c1);

Cookie c2=new Cookie("b","BBBBB");
response.addCookie(c2);



%>

<%
Cookie[] cookies= request.getCookies();
%>

<%=cookies[0].getName()+"-----"+cookies[0].getValue() %><br/>
<%=cookies[1].getName()+"-----"+cookies[1].getValue() %><br/>
<%=cookies[2].getName()+"-----"+cookies[2].getValue() %><br/>


只获取b的cookie <br/>
<%

for(Cookie c :cookies){
	
	if(c.getName().equals("b")){
		
		out.print(c.getValue());
		
		break;
	}
}


%>
<br/>
${cookie.b.name }<br/>
${cookie.b.value }<br/>


</body>
</html>