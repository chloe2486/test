<%@page import="java.util.ArrayList"%>
<%@page import="bean.keijiban_bean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>管理画面</title>
</head>
<body>
<a href="/kadai9/keijiban">掲示板</a>

<hr noshade="noshade" size="1">
<%
		ArrayList<keijiban_bean> list = (ArrayList<keijiban_bean>) request.getAttribute("list");
		for (int i = list.size() - 1; i > -1; i--) {
			keijiban_bean list2 = list.get(i);
	%>
			<hr noshade="noshade" size="1">
	<p><%=list2.getId()%>.<%=list2.getMail()%>.<%=list2.getName() %></p>
	<p>
		投稿日
		<%=list2.getTime() %>

	</p>
	<pre><%=list2.getComment()%></pre>
	<form action="/kadai9/delete" method="get">
	<input type="hidden" name="id" value=<%=list2.getId() %>>
		<input type="submit" value="削除">
	</form>
	<%} %>
	<hr noshade="noshade" size="1">
	<br>

</body>
</html>