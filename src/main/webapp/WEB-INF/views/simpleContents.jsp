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


태그!!
	<div>
		<c:forEach var="tag" items="${tags}">
			<a href="<spring:url value="/simpleContents">
				<spring:param name="tag" value="${tag.tag}"/>
			</spring:url>"><c:out value="${tag.tag}" /></a> ,
		</c:forEach>
	</div>
심플데이터 목록
<br/>
<form:form modelAttribute="search" method="get" cssStyle="background-color:#F4F4F4;">
	상태없음:<form:checkbox path="notUseSimpleStatus" value="true"/> <br/>
	<span id="status">
	상태:
	<form:select path="simpleStatus" items="${simpleStatusList}"/>
	</span>
	<form:button>검색</form:button>
</form:form>

<table>
<thead>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>상태</th>
		<th>등록자</th>
		<th><a href="?page.sort=createdDate&page.sort.dir=desc">등록일시</a></th>
	</tr>
</thead>
<tbody>
<c:set var="first" value="${page.size * page.number}"></c:set>
<c:forEach var="simpleContent" items="${page.content}" varStatus="status">
	<tr>
	    <td>${page.totalElements - (first + status.index)}</td>
		<td><a href="<spring:url value="/simpleContents/${simpleContent.id}"/>"><c:out value="${simpleContent.title}" /></a></td>
		<td><c:out value="${simpleContent.createdBy.name}" /></td>
		<td><c:out value="${simpleContent.status}" /></td>
		<td><joda:format value="${simpleContent.createdDate}" style="SM" /></td>
	</tr>
</c:forEach>
</tbody>
</table>

<spring:url value="/simpleContents" var="next">
   <spring:param name="page.page" value="${page.number + 2}" ></spring:param>
   <spring:param name="page.size" value="${page.size}" ></spring:param>
</spring:url>

<spring:url value="/simpleContents" var="prev">
   <spring:param name="page.page" value="${page.number}" ></spring:param>
   <spring:param name="page.size" value="${page.size}" ></spring:param>
</spring:url>

<c:if test="${!page.firstPage}">
<a href="${prev}">이전</a>
</c:if>
<c:if test="${!page.lastPage}">
<a href="${next}">다음</a>
</c:if>

<br/>
<a href="<spring:url value="/simpleContents/form"></spring:url>">심플컨텐츠등록</a>
</body>
</html>