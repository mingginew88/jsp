<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="/jspTest/main/main.jsp">Main <span class="sr-only">(current)</span></a></li>
		<li class="active"><a href="/jspTest/memberInfo">회원정보</a></li>
		<li class="active"><a href="/jspTest/boardList">게시판</a></li>
	</ul>
	
	<ul class="nav nav-sidebar" id="allBoard">
		<c:forEach items="${boardList}" var="boardVo">
			<c:choose>
				<c:when test="${boardVo.board_use_confirm == 'Y' }">
					<li class="list-item active" id="activeBoard"><a href="/jspTest/showBoardList?board_no=${boardVo.board_no}&page=1&pageSize=10">${boardVo.board_name}</a></li>
				</c:when>
				<c:when test="${boardVo.board_use_confirm == 'N' }">
					<li class="active" ><a href="/jspTest/showBoardList?board_no=${boardVo.board_no}&page=1&pageSize=10" style="display: none;">${boardVo.board_name}</a></li>
				</c:when>
			</c:choose>			
		</c:forEach>
	</ul>	
</div>

