<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">


setTimeout(() => {
	
	location.href="<%=request.getContextPath() %>/index.html";
	
}, 3000);

</script>
</head>
<body>
服务器发生问题，请与管理员联系

</body>
</html>