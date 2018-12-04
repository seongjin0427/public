<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리스트 페이지</title>
</head>
<body>

<div align="center">
	<table style="text-align: center;">
		<tr>
			<td width="10%">번호</td>
			<td width="20%">제목</td>
			<td width="*">내용</td>
			<td width="15%">작성일</td>
			<td width="15%">마감시한</td>
			<td width="*"></td>
		</tr>
		<c:forEach var="todo" items="${lists}">
		<tr>
			<td>${todo.id}</td>
			<td>${todo.subject}</td>
			<td>${todo.content}</td>
			<td>${todo.created}</td>
			<td>${todo.deadline}</td>
			<td>
			<input type="button" value="수정" onclick="javascript:location.href='${cp}/updated?id=${todo.id}'"/>
			<input type="button" value="삭제" onclick="javascript:location.href='${cp}/deleted?id=${todo.id}'"/>
			</td>
		</tr>
		</c:forEach>
		<tr>
			<td><input type="button" value="작성하기" onclick="javascript:location.href='${cp}/created';"/></td>
		</tr>
	</table>
</div>
</body>
</html>