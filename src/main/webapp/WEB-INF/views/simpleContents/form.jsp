<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix="spring" uri="http://www.springframework.org/tags"
 %><%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" 
 %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" 
 %><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" 
 %><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" 
 %><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
심플컨텐츠 등록/수정
<form:form modelAttribute="simpleContent" method="post">
	<form:hidden path="id"/>
	<table>
		<colgroup>
			<col />
			<col />
			<col />
			<col />
		</colgroup>
		<tbody>
		<tr>
			<th>제목</th>
			<td colspan="3"><form:input path="title" /></td>
		</tr>
		<tr>
			<th>상태</th>
			<td colspan="3"><form:select path="status" items="${simpleStatusList}"/></td>
		</tr>
		<tr>
			<th>태그</th>
			<td>
				<form:input path="simpleTagText" />
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3">
				<form:textarea path="content" rows="10" cols="80"/>
			</td>
		</tr>
		</tbody>
	</table>
	<form:button>등록</form:button>
</form:form>
<a href="<spring:url value="/simpleContents"/>">목록</a>
</body>
</html>