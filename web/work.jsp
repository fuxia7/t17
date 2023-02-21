<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   
    <% String lUserName=(String)session.getAttribute("lUserName");%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登录系统</title>
</head>
<body style="text-align:center">
<% if (lUserName != ""&&lUserName!=null) { %>
     欢迎光临，<%=lUserName%><br><br>
     <a href="loginserv?action=logout">退出登录</a>
<% } else { %>
<h1>欢迎来到登录系统</h1>
	<form action="LoginServlet" method="post">
	
		<h3>用户名:<input type="text" name="name"></h3>
		
		<h3>密&nbsp;&nbsp;码:<input type="password" name="password"></h3>
	
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		
		<input type="submit" value="登录">
		
		<input type="reset" value="重置">
		
	</form>

<% } %>
</body>
</html>