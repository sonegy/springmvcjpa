<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix="spring" uri="http://www.springframework.org/tags"
 %><%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" 
 %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" 
 %><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" 
 %><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" 
 %><%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" 
 %><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
심플컨텐츠
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
			<td colspan="3"><c:out value="${simpleContent.title}" /></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><c:out value="${simpleContent.createdBy.name}" /></td>
			<th>작성시간</th>
			<td><joda:format value="${simpleContent.createdDate}" style="SM" /></td>
		</tr>
		<tr>
			<th>테그</th>
			<td colspan="3">
				<c:forEach var="tag" items="${simpleContent.simpleTags}" varStatus="status">
					<c:if test="${!status.first}">,</c:if>
					<c:out value="${tag.tag}"></c:out>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<th>상태</th>
			<td colspan="3"><c:out value="${simpleContent.status}" /></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3">
				<c:out value="${simpleContent.content}"></c:out>
			</td>
		</tr>
		</tbody>
	</table>
	
<a href="<spring:url value="/simpleContents/form"><spring:param name="id" value="${simpleContent.id}"/></spring:url>">수정</a>
<a href="<spring:url value="/simpleContents/delete"><spring:param name="id" value="${simpleContent.id}"/></spring:url>">삭제</a>
<a href="<spring:url value="/simpleContents"/>">목록</a>
</body>
</html>