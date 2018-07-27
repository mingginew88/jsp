package syj.attachment.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import syj.attachment.model.AttachmentVo;

public class AttachmentServiceTest {
	
	AttachmentServiceInf attachmentService = new AttachmentService();

	/**
	* Method : getAttachmentOfArticleTest
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : SEO
	* 변경이력 :
	* Method 설명 : 해당 게시글의 첨부파일 조회
	*/
	@Test
	public void getAttachmentOfArticleTest() {
		/***Given***/
		int article_no = 1;
		/***When***/
		List<AttachmentVo> attachmentList = attachmentService.getAttachmentOfArticle(article_no);

		/***Then***/
		assertEquals(0, attachmentList.size());
	}

	
	/**
	* Method : deleteAttachmentTest
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : SEO
	* 변경이력 :
	* Method 설명 : 첨부파일 삭제
	*/
	@Test
	public void deleteAttachmentTest() {
		/***Given***/
		int article_no = 1;
		
		/***When***/
		int result = attachmentService.deleteAttachment(article_no);

		/***Then***/
		assertEquals(1, result);
	}
	
	
	/**
	* Method : getAttachment
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC17
	* 변경이력 :
	* @param attach_no
	* @return
	* Method 설명 : 해당 첨부파일 조회
	*/
	@Test
	public void getAttachmentTest() {
		/***Given***/
		int attach_no = 96;

		/***When***/
		AttachmentVo attachmentVo = attachmentService.getAttachment(attach_no);
		
		/***Then***/
		assertEquals("sally.png", attachmentVo.getAttach_upload_name());
	}
	
	
	
	
	
	
}
