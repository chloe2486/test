<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.catalina.User"%>
<%@page import="bean.keijiban_bean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>keijiban</title>
</head>
<body>
<h1>掲示板</h1>
<a href="/kadai9/kanri">管理画面</a>

<form action="/kadai9/toukou" method="get">

		名前<br>
		<input type="text" name="name" ><br>
		e-mail<br>
		<input type="text" name="mail"><br>
		内容<br>
		<textarea name="comment" rows='4' cols='60'></textarea><br>
		<input type="submit" value="投稿">

		<hr noshade="noshade" size="1">
	</form>

		<%
		ArrayList<keijiban_bean> list = (ArrayList<keijiban_bean>) request.getAttribute("list");
		for (int i = list.size() - 1; i > -1; i--) {
			keijiban_bean list2 = list.get(i);
	%>
	<p><%=list2.getId()%>.<%=list2.getName()%>
		投稿日
		<%=list2.getTime()%>
	</p>


	<pre><%=list2.getComment()%></pre>

	<br>
	<hr noshade="noshade" size="1">
	<%
			}
			%>
</body>
</html>