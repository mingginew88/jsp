<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- top.jsp -->
<%@ include file="/common/top.jsp"%>

<div class="container-fluid">
	<div class="row">

		<!-- left.jsp -->
		<%@ include file="/common/left.jsp"%>
		
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<form id="frm" class="form-horizontal" role="form">
				<input type="hidden" name="mem_id" value="${memberVo.mem_id}">				
				<div class="form-group">
					<label for="id" class="col-sm-2 control-label">프로필</label>
					<div class="col-sm-10">
						<img src="/jspTest/memberProfile?mem_id=${memberVo.mem_id}">
						<label class="control-label"></label>
					</div>
				</div>
				<div class="form-group">
					<label for="id"  class="col-sm-2 control-label">회원 아이디</label>
					<div class="col-sm-10">
						<label class="control-label">${memberVo.mem_id}</label>
					</div>
				</div>
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">회원 이름</label>
					<div class="col-sm-10">
						<label class="control-label">${memberVo.mem_name}</label>
					</div>
				</div>
				<div class="form-group">
					<label for="call_cnt" class="col-sm-2 control-label">호출횟수</label>
					<div class="col-sm-10">
						<label class="control-label">${memberVo.mem_call_cnt}</label>
					</div>
				</div>
				<div class="form-group">
					<label for="addr1" class="col-sm-2 control-label">주소</label>
					<div class="col-sm-10">
						<label class="control-label">${memberVo.mem_addr1}</label>
					</div>
				</div>
				<div class="form-group">
					<label for="addr2" class="col-sm-2 control-label">상세주소</label>
					<div class="col-sm-10">
						<label class="control-label">${memberVo.mem_addr2}</label>
					</div>
				</div>
				<div class="form-group">
					<label for="zipcd" class="col-sm-2 control-label">우편번호</label>
					<div class="col-sm-10">
						<label class="control-label">${memberVo.mem_zipcd}</label>
					</div>
				</div>
				<div class="form-group" >
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">회원정보 수정</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<!-- footer.jsp -->
<%@ include file="/common/footer.jsp"%>
