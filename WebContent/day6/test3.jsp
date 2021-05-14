<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

${2+5 }<br/>
${5*2 }<br/>
${5/2 }<br/>
${5%2 }<br/>
${(5-5%2)/2  }<br/>

${5==2 }<br/>
${5>2 }<br/>
${5<2 }<br/>

${true&&false }<br/>
${true||false }<br/>
${!true }<br/>


<%
String a ="null";
pageContext.setAttribute("a", a);
%>

${empty a }<br/>
${empty b }<br/>


<hr/>

${2+5 }<br/>
${5*2 }<br/>
${5 div 2 }<br/>
${5 mod 2 }<br/>
${(5-5 mod 2) div 2  }<br/>

${5 eq 2 }<br/>
${5 gt 2 }<br/>
${5 lt 2 }<br/>

${true and false }<br/>
${true or false }<br/>
${not true }<br/>


</body>
</html>