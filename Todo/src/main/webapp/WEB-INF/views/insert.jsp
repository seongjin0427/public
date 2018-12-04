<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>등록 페이지</title>

<script type="text/javascript">
	function sendIt(){
		
		f = document.myForm;
		
		str = f.subject.value;
		str = str.trim();
		if(!str){
			alert("\n제목을 입력하세요.");
			f.subject.focus();
			return;
		}
		f.subject.value = str;
		
		str = f.content.value;
		str = str.trim();
		if(!str){
			alert("\n내용을 입력하세요.");
			f.content.focus();
			return;
		}
		f.content.value = str;
		
		if(f.model.value == 'add'){
			f.action = "created_ok";
			f.submit();
		}else if (f.model.value == 'update') {
			f.action = "updated_ok?id=${todo.id}";
			f.submit();
		}
	}
</script>

</head>
<body>

<div align="center">
	<form action="" name="myForm" method="post">
	<input type="hidden" name="model" value="${todo.model}">
	<table>
	<tr>
		<td>제목: </td>
		<td><input type="text" name="subject" value="${todo.subject}"/></td>
	</tr>
	<tr>
		<td>마감시한: </td>
		<td><input type="date" name="deadline" value="${todo.deadline}"/></td>
	</tr>
	<tr>
		<td>내용: </td>
		<td><textarea rows="" cols="30" name="content" >${todo.subject}</textarea></td>
	</tr>
	<tr>
		<c:if test="${todo.model == 'add'}">
		<td colspan="2" align="center"><input type="button" value="등록" onclick="sendIt();"/> <input type="button" value="취소" onclick="javascript:location.href='list';"/></td>
		</c:if>
		<c:if test="${todo.model == 'update'}">
		<td colspan="2" align="center"><input type="button" value="수정" onclick="sendIt();"/> <input type="button" value="취소" onclick="javascript:location.href='list';"/></td>
		</c:if>
	</tr>
	</table>
	</form>
</div>

</body>
</html>