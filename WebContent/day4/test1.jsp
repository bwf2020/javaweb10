<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

day4  test1 page2

<!--
<%
int a=100;
%>
-->

<%
String b="hello";
boolean flag=true;
%>

<!-- 静态页面注释 -->

<%=1+1 %>

<%-- 
<%=1/0 %>
--%>

<%

String[] str={"张三","李四","王五"};



%>

<ul>

<%
 for(String s:str){
 %>
	
	<li><%=s %></li>

<%}%>	 



<%!

public void show2(){
	
	
}

%>

<%!
int c=200;
%>


 


</ul>





</body>
</html>