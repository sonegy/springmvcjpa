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
유저

	<table>
		<tbody>
		<tr>
			<th>이름</th>
			<td><c:out value="${user.name}" /></td>
		</tr>
		</tbody>
	</table>
	
<a href="<spring:url value="/users/form"><spring:param name="id" value="${user.id}"/></spring:url>">수정</a>
<a href="<spring:url value="/users/delete"><spring:param name="id" value="${user.id}"/></spring:url>">삭제</a>
<a href="<spring:url value="/users"/>">목록</a>
</body>
</html>