<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- top.jsp -->
<%@ include file="/common/top.jsp"%>

	<form id="frmArticle" action="/jspTest/articleDetail" method="get">
		<input type="hidden" name="article_no" id="article_no">
		<input type="hidden" name="board_no" value="${board_no}">
	</form>

	<div class="container-fluid">
		<div class="row">
	
			<!-- left.jsp -->
			<%@ include file="/common/left.jsp"%>
	
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">${board_name}</h2>
						<div class="table-responsive">
							<h3>${board_name} 리스트</h3>	
							<table class="table table-striped table-hover">
								<thead>
									<tr>
										<th>번호	</th>
										<th>제목	</th>
										<th>작성자</th>					
										<th>작성일</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${articleList}" var="vo">
										<c:choose>
											<c:when test="${vo.article_del_confirm=='N'}">
												<% pageContext.setAttribute("nbsp", " "); %>
												<%--tr태그 클릭시 상세페이지로 이동 --%>
												<tr data-id="${vo.article_no}">
													<td>${vo.article_no}		</td>
													<td>${fn:replace(vo.article_title, nbsp, '&nbsp;')}</td>
													<td>${vo.article_writer}	</td>
													<td><fmt:formatDate value="${vo.article_date}" pattern="yyyy-MM-dd"/>	</td>
												</tr>
											</c:when>
											<c:when test="${vo.article_del_confirm=='Y'}" >	
											<tr style="pointer-events: none;">
												<td >${vo.article_no}</td>
												<td>요청에 의해 삭제된 게시글 입니다.</td>
												<td>${vo.article_writer}	</td>
												<td><fmt:formatDate value="${vo.article_date}" pattern="yyyy-MM-dd"/></td>													
											</tr>										
											</c:when>
										</c:choose>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<form id="frmNewArticle" action="/jspTest/addArticle" method="get">
							<input type="submit" value="게시글 작성">
							<input type="hidden" name="board_no" value="${board_no}">
						</form>
						<div class="text-center">
							<ul class="pagination">
								<li>${pageNavi}</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>	
<!-- footer.jsp -->
<%@ include file="/common/footer.jsp" %>	
	