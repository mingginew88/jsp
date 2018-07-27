package syj.attachment.service;

import java.util.List;

import syj.attachment.model.AttachmentVo;

public interface AttachmentServiceInf {
	
	
	/**
	* Method : getAttachmentOfArticle
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC17
	* 변경이력 :
	* @param article_no
	* @return
	* Method 설명 : 해당 게시글의 첨부파일 조회
	*/
	List<AttachmentVo> getAttachmentOfArticle(int article_no);

	
	/**
	* Method : deleteAttachment
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC17
	* 변경이력 :
	* @param article_no
	* @return
	* Method 설명 : 첨부파일 삭제
	*/
	int deleteAttachment(int article_no);
	
	
	
	/**
	* Method : getAttachment
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC17
	* 변경이력 :
	* @param attach_no
	* @return
	* Method 설명 : 해당 첨부파일 조회
	*/
	AttachmentVo getAttachment(int attach_no);
	
	
}
