<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<%@ include file="/WEB-INF/views/include/base/metaHead.jsp" %>
	<title>메인</title>
</head>
<body>
<%@ include file="/WEB-INF/views/include/base/navbar.jsp" %>
<main class="container">
	<!-- 옵션 -->
    	<div>
    	</div>
    	
    <!-- 게시판 목록 -->
    <c:import url="/WEB-INF/views/include/post/posts_card.jsp">
    	<c:param name="url" value="${WebURLPattern.RECRUIT_POSTDETAIL }"/>
    </c:import>
    
	<!-- 게시판 페이징 -->
	<c:import url="/WEB-INF/views/include/post/post_paging.jsp">
		<c:param name="startPageNo" value="${pagingDto.startPageNumber }"/>
		<c:param name="endPageNo" value="${pagingDto.endPageNumber }"/>
		<c:param name="currentPageNo" value="${pagingDto.currentPage }"/>
		<c:param name="startPagingCheck" value="${pagingDto.prev }"/>
		<c:param name="endPagingCheck" value="${pagingDto.next }"/>
		<c:param name="url" value="#"/>
		<c:param name="tesr" value=""/>
	</c:import>
</main>
<%@ include file="/WEB-INF/views/include/base/footer.jsp" %>
</body>
</html>