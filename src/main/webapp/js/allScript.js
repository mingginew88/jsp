/**
 * 게시판 생성을 하는데 필요한 js
 * - 게시글 목록 상세조회
 * - 첨부파일추가,삭제
 * - 댓글 추가 
 */


//게시글 목록 클릭시 상세정보 조회
$(function(){
	$("table tbody tr").on("click", function(){
		$("#article_no").val($(this).data("id"));
		$("#frmArticle").submit();
	});
});
	
//첨부파일 추가버튼
var arrInput 	  = new Array(0);
var arrInputValue = new Array(0);

function addInput() {
	arrInput.push(arrInput.length);
	arrInputValue.push("");
	display();
}

function display() {
	document.getElementById('addAttach').innerHTML = "";
	for (intI = 0; intI < arrInput.length; intI++) {
		document.getElementById('addAttach').innerHTML += createInput(
				arrInput[intI], arrInputValue[intI]);
	}
}

function saveValue(intId, strValue) {
	arrInputValue[intId] = strValue;
}
//첨부파일 생성하기위한 input태그 추가
function createInput(id, value) {
	return "<div><input type='file' name='uploadFile'></div><br>";
}
//첨부파일 삭제
function deleteInput() {
	if (arrInput.length > 0) {
		arrInput.pop();
		arrInputValue.pop();
	}
	display();
}

var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.

$(document).ready(function() {
	// Editor Setting
	nhn.husky.EZCreator.createInIFrame({
		oAppRef : oEditors, // 전역변수 명과 동일해야 함.
		elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
		sSkinURI : "/SE2/SmartEditor2Skin.html", // Editor HTML
		fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
		htParams : {
			// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseToolbar : true,
			// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : true,
			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : true, 
		}
	});

	// 전송버튼 클릭이벤트
	$("#save").click(function(){
		if(confirm("저장하시겠습니까?")) {
			// id가 smarteditor인 textarea에 에디터에서 대입
			oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);

			// 이부분에 에디터 validation 검증
			if(validation()) {
				$("#frmAddArticle").submit();
			}
		}
	})
});

// 필수값 Check
function validation(){
	var contents = $.trim(oEditors[0].getContents());
	if(contents === '<p>&nbsp;</p>' || contents === ''){ // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
		alert("내용을 입력하세요.");
		oEditors.getById['smarteditor'].exec('FOCUS');
		return false;
	}
	return true;
}

//댓글 추가
//	<div><input type='text' id='test " + id + "' onChange='javascript:saveValue(" + id	+ ",this.value)' value='" +	value + "'>
function addReply() {
	return "<div><input name='reply_contents'></div>";
}	
