<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- top.jsp -->
<%@ include file="/common/top.jsp" %>
	
	<div class="container-fluid">
		<div class="row">

			<!-- left.jsp -->
			<%@ include file="/common/left.jsp" %>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<div class="row">

					<div class="col-sm-8 blog-main">

						<div class="blog-post">
							<h2 class="blog-post-title">설정 - 게시판</h2>
							<p class="blog-post-meta"><fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>, room 207</p>

							<p>게시판</p>
							<hr>
							<div class="table-responsive">
								<div class="form-group">
									<label for="id"  class="col-sm-2 control-label">게시판 이름</label>
									<div class="col-sm-10">
										<form action="/jspTest/addBoard" method="get">
											<input type="text" id="addBoardName" name="addBoardName">
											<select id="add_use_confirm" name="add_use_confirm">
												<option value="Y">사용</option>
												<option value="N">미사용</option>
											</select>
											<button class="btn btn-primary" type="submit">게시판 생성</button>
										</form>
									</div>
								</div>
								<hr>
								<c:forEach items="${boardList}" var="boardVo">
									<div class="form-group">
										<label for="id"  class="col-sm-2 control-label">게시판 이름</label>
										<div class="col-sm-10">
											<form action="/jspTest/updateBoard" method="get">
												<input type="hidden" id="${boardVo.board_no}" name="board_no" value="${boardVo.board_no}" >
												<input type="text" name="updateBoardName" value="${boardVo.board_name}">
												<select id="update_use_confirm" name="update_use_confirm">
													<option value="${boardVo.board_use_confirm}">
														<c:choose>
															<c:when test="${boardVo.board_use_confirm == 'Y'}">사용</c:when>
															<c:when test="${boardVo.board_use_confirm == 'N'}">미사용</c:when>
														</c:choose>
													</option>
													<option value="Y">사용</option>
													<option value="N" >미사용</option>
												</select>
												<button id="btnUpdateBoard" class="btn btn-primary" type="submit">수정</button>												
											</form>
											<br>
										</div>
									</div>
								</c:forEach>
							</div>
							<div class="text-center">
							<ul class="pagination">
								<li>${pageNavi}</li>
							</ul>
						</div>
						</div>
					</div>
					<!-- /.blog-main -->
				</div>
			</div>
		</div>
	</div>
	
<!-- footer.jsp -->
<%@ include file="/common/footer.jsp" %>
	