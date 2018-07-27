<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%@ include file="/common/top.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<!-- left.jsp -->
			<%@ include file="/common/left.jsp" %>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	
				<form id="frmAddArticle" action="/jspTest/addArticleResult" method="post" enctype="multipart/form-data">
					<input type="hidden" name="board_no" value="${board_no}">
					<input type="hidden" name="article_no" value="${article_no}">
					<table width="100%">
					        <tr>
					            <td>제목</td>
					            <td><input type="text" id="title" name="title" style="width:650px"/></td>
					        </tr>
					        <tr>
					            <td>내용</td>
					            <td>
					                <textarea rows="10" cols="30" id="smarteditor" name="smarteditor" style="width:650px; height:350px; "></textarea>
					            </td>
					        </tr>
					         <tr>
					            <td>첨부파일</td>
					            <td>
						            <div id="addAttach">
<!-- 					                	<input type="file" name="uploadFile" style="width:650px"/> -->
						            </div>						            
				                	<input type="button" value="추가" onclick="addInput();" />
									<input type="button" value="삭제" onclick="deleteInput();"/>
					            </td>
					        </tr>
					        <tr>
					            <td colspan="2">
					                <input type="submit" id="save" value="저장"/>
					                <input type="button" value="취소" onClick="history.back();"/>
					            </td>
					        </tr>
					</table>
				</form>
			</div>
		</div>
	</div>
<%@ include file="/common/footer.jsp" %>