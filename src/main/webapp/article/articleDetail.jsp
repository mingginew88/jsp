<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- top.jsp -->
<%@ include file="/common/top.jsp" %>

	<style>
	body {font-style:'Malgun Gothic';background-color: '#333'}
	.font-nanum {font-style:'Nanum Gothic'}
	</style>
	
	<div class="container-fluid">
		<div class="row">

			<!-- left.jsp -->
			<%@ include file="/common/left.jsp" %>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<div class="row">

					<div class="col-sm-8 blog-main">

						<div class="blog-post">
							<h2 class="sub-header font-nanum" style="font-style: italic;">${articleVo.article_no}번 게시글</h2>
							<p class="blog-post-meta"><fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/></p>
							
							<hr>
							<div class="table-responsive">
								<div class="form-group col-sm-12 control-label" style="margin-bottom:20px;">
									<label class="col-sm-2 control-label">제목</label>
									<label for="title"  class="col-sm-10 control-label">${articleVo.article_title}</label>									
								</div>
								<div class="form-group col-sm-12 control-label" style="margin-bottom:20px;">
									<label class="col-sm-2 control-label">작성자</label>
									<label for="writer"  class="col-sm-10 control-label">${articleVo.article_writer}</label>									
								</div>															
								<div class="form-group col-sm-12 control-label" style="margin-bottom:20px;">
									<label class="col-sm-2 control-label">글 내용</label>
									<label for="content"  class="col-sm-10 control-label">${articleVo.article_content}</label>	
								</div>
								
								<!-- 첨부파일....for each 사용하기 -->
								<div class="form-group col-sm-12 control-label">
									<label for="id"  class="col-sm-2 control-label">첨부파일</label>
									<table class="col-sm-10">
										<c:forEach items="${attachmentList}" var="attachmentVo">										
											<tr>
												<td>
													<c:choose>
														<c:when test="${articleVo.mem_id == mem_id}" >
															<form action="/jspTest/deleteAttach" method="get">														
																<label for="attach_name">${attachmentVo.attach_upload_name} </label>
																<input type="hidden" name="attach_no" value="${attachmentVo.attach_no}" >
																<input type="hidden" name="article_no" value="${article_no}">
																<input type="hidden" name="board_no" value="${board_no}" >
																<input type="submit" value="ㅡ" >
															</form>
														</c:when>
														<c:otherwise>
															<form action="/jspTest/deleteAttach" method="get">														
																<label for="attach_name">${attachmentVo.attach_upload_name} </label>
																<input type="hidden" name="attach_no" value="${attachmentVo.attach_no}" >
																<input type="hidden" name="article_no" value="${article_no}">
																<input type="hidden" name="board_no" value="${board_no}" >
																<input type="submit" value="ㅡ" style="pointer-events: none;">
															</form>	
														</c:otherwise>
													</c:choose>														
													<form action="/jspTest/fileDownload" method="get">
														<input type="hidden" name="article_no" value="${article_no}" >
														<input type="hidden" name="attach_no" value="${attachmentVo.attach_no}" >
														<input type="submit" value="파일 다운로드" >
													</form>
												</td>
											</tr>
										</c:forEach>
									</table>
								</div>
								
								<div class="form-group col-sm-12 control-label">
									<label for="reply"  class="col-sm-2 control-label">댓글</label>
									<!-- 댓글 for each 사용하기 -->
									<table class="col-sm-10 control-label">
										<c:forEach items="${replyList}" var="replyVo">
											<c:if test="${replyVo.reply_del_confirm =='N'}">
												<tr>
													<td>
														<div>
															<c:choose>
																<c:when test="${articleVo.mem_id == mem_id}" >
																	<form action="/jspTest/deleteReply" method="get">
																		<input type="hidden" name="reply_no" value="${replyVo.reply_no}" >
																		<input type="hidden" name="article_no" value="${article_no}" >
																		<input type="hidden" name="board_no" value="${board_no}" >
																		<label for="reply_writer">${replyVo.reply_writer} </label>
																		작성일시 :<label for="reply_date"><fmt:formatDate value="${replyVo.reply_date}" pattern="yyyy-MM-dd"/></label><br>
																		<input value="${replyVo.reply_content}" name="reply_content" style="width : 200px" readonly/>
																		<input type="submit" value="X" >
																	</form>
																</c:when>
																<c:otherwise>
																	<form action="/jspTest/deleteReply" method="get">
																		<input type="hidden" name="reply_no" value="${replyVo.reply_no}" >
																		<input type="hidden" name="article_no" value="${article_no}" >
																		<input type="hidden" name="board_no" value="${board_no}" >
																		<label for="reply_writer">${replyVo.reply_writer} </label>
																		작성일시 :<label for="reply_date"><fmt:formatDate value="${replyVo.reply_date}" pattern="yyyy-MM-dd"/></label><br>
																		<input value="${replyVo.reply_content}" name="reply_content" style="width : 200px" readonly/>
																		<input type="submit" value="X" style="pointer-events: none;">
																	</form>
																</c:otherwise>
															</c:choose>														
														</div>
													</td>
												</tr>
											</c:if>											
										</c:forEach>
									</table>
								</div>
								
								<div class="form-group">
									<form action="/jspTest/addReply" method="get">
										<div class="col-sm-12">
											<input name="reply_content" style="width : 350px">
											<input type="hidden" name="article_no" value="${article_no}" >
											<input type="hidden" name="board_no" value="${board_no}" >
											<button class="btn btn-primary" type="submit">댓글저장</button>
										</div>					
									</form>
								</div>
							</div>
							<div class="container-fluid">
							    <div class="row">
									<c:choose>
										<c:when test="${articleVo.mem_id == mem_id}" >
											<div class="col-sm-1">
												<form class="form-signin" action="/jspTest/updateArticle" method="get">
													<input type="hidden" name="article_no" value="${article_no}" >
													<input type="hidden" name="board_no" value="${board_no}" >
													<button class="btn btn-primary" type="submit" style="float:none">수정</button>
												</form>	
											</div>
											<div class="col-sm-1">
												<form class="form-signin" action="/jspTest/deleteArticle" method="get">
													<input type="hidden" name="article_no" value="${article_no}" >
													<input type="hidden" name="board_no" value="${board_no}" >
													<button class="btn btn-warning btn" type="submit" style="float:none">삭제</button>
												</form>
											</div>											
										</c:when>
										<c:otherwise>
											<div class="col-sm-1">
												<form class="form-signin" action="/jspTest/updateArticle" method="get">
													<input type="hidden" name="article_no" value="${article_no}" >
													<input type="hidden" name="board_no" value="${board_no}" >
													<button class="btn btn-primary" type="submit" style="float:none; pointer-events: none;">수정</button>
												</form>	
											</div>
											<div class="col-sm-1">
												<form class="form-signin" action="/jspTest/deleteArticle" method="get">
													<input type="hidden" name="article_no" value="${article_no}" >
													<input type="hidden" name="board_no" value="${board_no}" >
													<button class="btn btn-warning btn" type="submit" style="float:none; pointer-events: none;">삭제</button>
												</form>
											</div>
										</c:otherwise>
									</c:choose>
									<div class="col-sm-1">
										<form class="form-signin" action="/jspTest/addArticle2" method="get">
											<input type="hidden" name="article_no" value="${article_no}" >
											<input type="hidden" name="board_no" value="${board_no}" >
											<input type="hidden" name="article_gno" value="${articleVo.article_gno}" >
											<button class="btn btn-success" type="submit" style="float:none">답글</button>
										</form>
									</div>
									<div class="col-sm-1">
										<form class="form-signin" action="#">
											<button class="btn btn-basic" type="submit" style="float:none" onClick="history.back();">뒤로</button>
										</form>
									</div>
								</div>
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